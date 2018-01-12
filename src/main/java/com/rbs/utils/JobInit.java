package com.rbs.utils;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.*;

/**
 * Created by fengtao.xue on 2018/1/12.
 */
public class JobInit {
    //input path
    private String[] inPath;
    //output path
    private String outPath;
    //configuration information
    private Configuration conf;
    //job
    private Job job;
    //job name
    private String jobName;
    //jar
    private Class<?> jarClass;
    //inputformat
    private Class<? extends InputFormat> inputFormatClass;
    //mapper的实现类
    private Class<? extends Mapper> mapper;
    //mapper输出的key类型
    private Class<?> mapOutKeyClass;
    //mapper输出的value类型
    private Class<?> mapOutValueClass;
    private Class<? extends Reducer> combinerClass;
    private Class<? extends Partitioner> partitionerClass;
    //reducer的实现类
    private Class<? extends Reducer> reducer;
    //reduce输出的key类型
    private Class<?> reduceOutKeyClass;
    //reduce输出的value类型
    private Class<?> reduceOutValueClass;

    public JobInit() {
    }

    public JobInit(String[] inPath, String outPath, Configuration conf, Job job, String jobName
            , Class<?> jarClass, Class<? extends InputFormat> inputFormatClass, Class<? extends Mapper> mapper
            , Class<?> mapOutKeyClass, Class<?> mapOutValueClass, Class<? extends Reducer> combinerClass
            , Class<? extends Partitioner> partitionerClass, Class<? extends Reducer> reducer
            , Class<?> reduceOutKeyClass, Class<?> reduceOutValueClass) {
        this.inPath = inPath;
        this.outPath = outPath;
        this.conf = conf;
        this.job = job;
        this.jobName = jobName;
        this.jarClass = jarClass;
        this.inputFormatClass = inputFormatClass;
        this.mapper = mapper;
        this.mapOutKeyClass = mapOutKeyClass;
        this.mapOutValueClass = mapOutValueClass;
        this.combinerClass = combinerClass;
        this.partitionerClass = partitionerClass;
        this.reducer = reducer;
        this.reduceOutKeyClass = reduceOutKeyClass;
        this.reduceOutValueClass = reduceOutValueClass;
    }

    public String[] getInPath() {
        return inPath;
    }

    public void setInPath(String[] inPath) {
        this.inPath = inPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public Configuration getConf() {
        return conf;
    }

    public void setConf(Configuration conf) {
        this.conf = conf;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Class<?> getJarClass() {
        return jarClass;
    }

    public void setJarClass(Class<?> jarClass) {
        this.jarClass = jarClass;
    }

    public Class<? extends InputFormat> getInputFormatClass() {
        return inputFormatClass;
    }

    public void setInputFormatClass(Class<? extends InputFormat> inputFormatClass) {
        this.inputFormatClass = inputFormatClass;
    }

    public Class<? extends Mapper> getMapper() {
        return mapper;
    }

    public void setMapper(Class<? extends Mapper> mapper) {
        this.mapper = mapper;
    }

    public Class<?> getMapOutKeyClass() {
        return mapOutKeyClass;
    }

    public void setMapOutKeyClass(Class<?> mapOutKeyClass) {
        this.mapOutKeyClass = mapOutKeyClass;
    }

    public Class<?> getMapOutValueClass() {
        return mapOutValueClass;
    }

    public void setMapOutValueClass(Class<?> mapOutValueClass) {
        this.mapOutValueClass = mapOutValueClass;
    }

    public Class<? extends Reducer> getCombinerClass() {
        return combinerClass;
    }

    public void setCombinerClass(Class<? extends Reducer> combinerClass) {
        this.combinerClass = combinerClass;
    }

    public Class<? extends Partitioner> getPartitionerClass() {
        return partitionerClass;
    }

    public void setPartitionerClass(Class<? extends Partitioner> partitionerClass) {
        this.partitionerClass = partitionerClass;
    }

    public Class<? extends Reducer> getReducer() {
        return reducer;
    }

    public void setReducer(Class<? extends Reducer> reducer) {
        this.reducer = reducer;
    }

    public Class<?> getReduceOutKeyClass() {
        return reduceOutKeyClass;
    }

    public void setReduceOutKeyClass(Class<?> reduceOutKeyClass) {
        this.reduceOutKeyClass = reduceOutKeyClass;
    }

    public Class<?> getReduceOutValueClass() {
        return reduceOutValueClass;
    }

    public void setReduceOutValueClass(Class<?> reduceOutValueClass) {
        this.reduceOutValueClass = reduceOutValueClass;
    }
}
