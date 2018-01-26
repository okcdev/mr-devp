package com.rbs.cn.hbase.hbutils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.mapreduce.Job;

/**
 * Created by fengtao.xue on 2018/1/26.
 */
public class HbaseJob {

    private String jobName;
    private Configuration conf;
    private Job job;
    private Scan scan;
    private int scanCache;
    private boolean cacheBlock;
    private Class<?> classJar;
    private Class<? extends TableMapper> mapperClass;
    private Class<? extends TableReducer> reduceClass;
    private TableName inputTable;
    private String outputTable;
    private Class<?> mapperOutputKey;
    private Class<?> mapperOutputValue;
    private Class<?> reducerOutputKey;
    private Class<?> getReducerOutputValue;
    private int numReduce;

    public HbaseJob(){

    }

    public HbaseJob(String jobName, Configuration conf, Job job, Scan scan,
                    int scanCache, boolean cacheBlock, Class<?> classJar,
                    Class<? extends TableMapper> mapperClass, Class<? extends TableReducer> reduceClass, TableName inputTable,
                    String outputTable, Class<?> mapperOutputKey, Class<?> mapperOutputValue,
                    Class<?> reducerOutputKey, Class<?> getReducerOutputValue, int numReduce) {
        this.jobName = jobName;
        this.conf = conf;
        this.job = job;
        this.scan = scan;
        this.scanCache = scanCache;
        this.cacheBlock = cacheBlock;
        this.classJar = classJar;
        this.mapperClass = mapperClass;
        this.reduceClass = reduceClass;
        this.inputTable = inputTable;
        this.outputTable = outputTable;
        this.mapperOutputKey = mapperOutputKey;
        this.mapperOutputValue = mapperOutputValue;
        this.reducerOutputKey = reducerOutputKey;
        this.getReducerOutputValue = getReducerOutputValue;
        this.numReduce = numReduce;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public int getScanCache() {
        return scanCache;
    }

    public void setScanCache(int scanCache) {
        this.scanCache = scanCache;
    }

    public boolean isCacheBlock() {
        return cacheBlock;
    }

    public void setCacheBlock(boolean cacheBlock) {
        this.cacheBlock = cacheBlock;
    }

    public Class<?> getClassJar() {
        return classJar;
    }

    public void setClassJar(Class<?> classJar) {
        this.classJar = classJar;
    }

    public Class<? extends TableMapper> getMapperClass() {
        return mapperClass;
    }

    public void setMapperClass(Class<? extends TableMapper> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Class<? extends TableReducer> getReduceClass() {
        return reduceClass;
    }

    public void setReduceClass(Class<? extends TableReducer> reduceClass) {
        this.reduceClass = reduceClass;
    }

    public TableName getInputTable() {
        return inputTable;
    }

    public void setInputTable(TableName inputTable) {
        this.inputTable = inputTable;
    }

    public String getOutputTable() {
        return outputTable;
    }

    public void setOutputTable(String outputTable) {
        this.outputTable = outputTable;
    }

    public Class<?> getMapperOutputKey() {
        return mapperOutputKey;
    }

    public void setMapperOutputKey(Class<?> mapperOutputKey) {
        this.mapperOutputKey = mapperOutputKey;
    }

    public Class<?> getMapperOutputValue() {
        return mapperOutputValue;
    }

    public void setMapperOutputValue(Class<?> mapperOutputValue) {
        this.mapperOutputValue = mapperOutputValue;
    }

    public Class<?> getReducerOutputKey() {
        return reducerOutputKey;
    }

    public void setReducerOutputKey(Class<?> reducerOutputKey) {
        this.reducerOutputKey = reducerOutputKey;
    }

    public Class<?> getGetReducerOutputValue() {
        return getReducerOutputValue;
    }

    public void setGetReducerOutputValue(Class<?> getReducerOutputValue) {
        this.getReducerOutputValue = getReducerOutputValue;
    }

    public int getNumReduce() {
        return numReduce;
    }

    public void setNumReduce(int numReduce) {
        this.numReduce = numReduce;
    }
}
