package com.rbs.had;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by fengtao.xue on 2018/1/7.
 */
public class MRMain {

    public static void main(String[] args) throws Exception{
        //输入路径
        String dst = "hdfs://us01:9000/mrdemo/input.txt";
        //输出路径，必须是不存在的，空文件加也不行。
        String dstOut = "hdfs://us01:9000/mrdemo//output.txt";
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //如果需要打成jar运行，需要下面这句
        job.setJarByClass(MRMain.class);
        //job执行作业时输入和输出文件的路径
        FileInputFormat.addInputPath(job, new Path(dst));
        FileOutputFormat.setOutputPath(job, new Path(dstOut));
        //指定自定义的Mapper和Reducer作为两个阶段的任务处理类
        job.setMapperClass(MRMapper.class);
        job.setReducerClass(MRReducer.class);
        //设置最后输出结果的Key和Value的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        //执行job，直到完成
        job.waitForCompletion(true);

    }
}