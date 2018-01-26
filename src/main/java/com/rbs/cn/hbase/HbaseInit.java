package com.rbs.cn.hbase;

import com.rbs.cn.utils.HbaseJob;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

/**
 * Created by admin on 2018/1/26.
 */
public class HbaseInit {

    public void hbaseInit(HbaseJob hbaseJob) throws IOException, ClassNotFoundException, InterruptedException {

        Job job;
        if (hbaseJob.getJob() == null) {
            //job = new Job(hbaseJob.getConf(),hbaseJob.getJobName());
            job = Job.getInstance(hbaseJob.getConf(), hbaseJob.getJobName());
        } else {
            job = hbaseJob.getJob();
        }

        // class that contains mapper and reducer
        job.setJarByClass(hbaseJob.getClassJar());

        Scan scan;
        if (hbaseJob.getScan() == null) {
            scan = new Scan();
        } else {
            scan = hbaseJob.getScan();
        }
        // 1 is the default in Scan, which will be bad for MapReduce jobs
        scan.setCaching(hbaseJob.getScanCache());
        // don't set to true for MR jobs
        scan.setCacheBlocks(hbaseJob.isCacheBlock());
        //set other scan attrs

        TableMapReduceUtil.initTableMapperJob(
                hbaseJob.getInputTable(), // input table
                scan, // Scan instance
                hbaseJob.getMapperClass(), // mapper class
                hbaseJob.getMapperOutputKey(), // mapper output key
                hbaseJob.getMapperOutputValue(), // mapper output value
                job
        );

        TableMapReduceUtil.initTableReducerJob(
                hbaseJob.getOutputTable(),      // output table
                null,             // reducer class
                job);

        job.setNumReduceTasks(0);

        boolean b = job.waitForCompletion(true);
        if (!b) {
            throw new IOException("error with job!");
        }
    }
}
