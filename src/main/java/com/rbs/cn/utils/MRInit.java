package com.rbs.cn.utils;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * Created by fengtao.xue on 2018/1/12.
 */
public class MRInit {
    /**
     * 初始化mr程序参数
     */

    /**
     * 一个或者多个保存着job信息的JobInit对象
     * @param jobs
     */
    public static void initAndRunJob(JobInit[] jobs) throws IOException, ClassNotFoundException, InterruptedException {
        for (JobInit jobInit : jobs){
            //检查hdfs上输出目录
            FileSystem fs = FileSystem.get(jobInit.getConf());
            Path fileOutPath = new Path(jobInit.getOutPath());
            if(fs.exists(fileOutPath)){
                fs.delete(fileOutPath,true);
            }

            //初始化job
            Job job;
            if (jobInit.getJob() == null){
                job = Job.getInstance(jobInit.getConf(), jobInit.getJobName());
            }else{
                job = jobInit.getJob();
            }

            //设置job的jar
            job.setJarByClass(jobInit.getJarClass());

            //设置InputFormat和输入路径
            // 遍历输入路径，可能有多个输入路径
            String[] inputPathsStr = jobInit.getInPath();
            Path[] inputPath = new Path[inputPathsStr.length];
            for (int i = 0; i < inputPathsStr.length; i++){
                inputPath[i] = new Path(inputPathsStr[i]);
            }
            FileInputFormat.setInputPaths(job, inputPath);
            //设置inputFormat类型（map输入类型）
            if (jobInit.getInputFormatClass() != null){
                job.setInputFormatClass(jobInit.getInputFormatClass());
            }else {
                job.setInputFormatClass(TextInputFormat.class);
            }

            //mapper类相关设置
            //设置map类，map输出k和v类型
            job.setMapperClass(jobInit.getMapper());
            job.setMapOutputKeyClass(jobInit.getMapOutKeyClass());
            job.setMapOutputValueClass(jobInit.getMapOutValueClass());

            //partitioner类相关设置
            if (jobInit.getPartitionerClass() != null){
                job.setPartitionerClass(jobInit.getPartitionerClass());
            }

            //combine类相关设置
            if (jobInit.getCombinerClass() != null){
                job.setCombinerClass(jobInit.getCombinerClass());
            }

            //reducer类相关设置
            if (jobInit.getReducer() != null){
                job.setReducerClass(jobInit.getReducer());
                job.setOutputKeyClass(jobInit.getReduceOutKeyClass());
                job.setOutputValueClass(jobInit.getReduceOutValueClass());
            }

            //设置输出目录和输出format类型
            FileOutputFormat.setOutputPath(job, fileOutPath);
            job.setOutputFormatClass(TextOutputFormat.class);

            //作业提交
            job.waitForCompletion(true);

        }
    }
}
