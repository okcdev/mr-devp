package com.rbs.cn.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengtao.xue on 2018/1/12.
 */
public class HdfsUtil {

    static Logger logger = LoggerFactory.getLogger(HdfsUtil.class);

    /**
     * hdfs根目录
     */
    public static final String HDFS = "hdfs://us01:9000/";
    private static final Configuration conf = new Configuration();

    /**
     * hdfs 创建文件夹
     * @param folder
     * @throws IOException
     */
    public static void mkdir(String folder) throws IOException{
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        if (!fs.exists(path)){
            fs.mkdirs(path);
            logger.debug("mkdir: {}", folder);
        }
        fs.close();
    }

    /**
     * hdfs 删除文件夹
     * @param folder
     * @throws IOException
     */
    public static void rmr(String folder) throws IOException{
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.deleteOnExit(path);
        logger.debug("rmr: {}", folder);
        fs.close();
    }

    /**
     * hdfs 重命名文件名
     * @param srcFolder
     * @param dstFolder
     * @throws IOException
     */
    public static void rename(String srcFolder, String dstFolder) throws IOException {
        Path srcPath = new Path(srcFolder);
        Path dstPath = new Path(dstFolder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.rename(srcPath, dstPath);
        logger.debug("rename: {} --> {}", srcFolder, dstFolder);
        fs.close();
    }

    /**
     * 列出当前路径所有文件
     * @param folder
     * @throws IOException
     */
    public static List<String> ls(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        FileStatus[] fsStatus = fs.listStatus(path);
        List<String> result = new ArrayList<String>();
        System.out.println("ls: " + folder);
        System.out.println("------------------------------------------");
        for (FileStatus f : fsStatus){
            System.out.printf("name: %s, filder: %s, size: %d\n", f.getPath(), f.isDirectory(), f.getLen());
            Path file = f.getPath();
            if(fs.isFile(file)){
                result.add(file.toString());
            }
        }
        System.out.println("------------------------------------------");
        fs.close();
        return result;
    }

    /**
     * hdfs 创建文件并且写文件
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void mkFile(String fileName, String content) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        byte[] buff = content.getBytes();
        FSDataOutputStream os = null;
        try {
            os = fs.create(new Path(fileName));
            os.write(buff, 0, buff.length);
            logger.debug("mkfile: {}", fileName);
        } finally {
            if (os != null)
                os.close();
        }
        fs.close();
    }

    /**
     * 复制本地文件到hdfs
     * @param local
     * @param remote
     * @throws IOException
     */
    public static void copyToHDFS(String local, String remote) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        logger.debug("upload from: {} to {}", local, remote);
        fs.close();
    }

    /**
     * 复制hdfs文件到本地
     * @param remote
     * @param local
     * @throws IOException
     */
    public static void copyToLocal(String remote, String local) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.copyToLocalFile(new Path(remote), new Path(local));
        logger.debug("download from: {} to {}", remote, local);
        fs.close();
    }

    public static void cat(String remoteFile) throws IOException {
        Path path = new Path(remoteFile);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        FSDataInputStream is = null;
        System.out.println("cat: " + remoteFile);
        try{
            is = fs.open(path);
            IOUtils.copyBytes(is, System.out, 4096, false);
        }finally {
            IOUtils.closeStream(is);
            fs.close();
        }
    }
}
