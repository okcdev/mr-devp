package com.rbs.cn.hbase.wordcount;

import com.rbs.cn.hbase.hbutils.HbaseInit;
import com.rbs.cn.utils.HbaseJob;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.io.IntWritable;

import javax.xml.soap.Text;
import java.io.IOException;

/**
 * Created by admin on 2018/1/26.
 */
public class HbMain {

    static  Configuration config;

    static {
        config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.property.clientPort", "2181");
        config.set("hbase.zookeeper.quorum", "192.168.1.100");
        config.set("hbase.master", "192.168.1.100:600000");
    }

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        TableName tableName = TableName.valueOf("wc");
        String outputTable = "wc-out";
        String jobName = "wc-demo";

        //hbasic.insertDate(config, "tbtest");

        HbaseJob hbaseJob = new HbaseJob(jobName, config, null, null, 500, false, HbMain.class, HbMapper.class,
                HbReducre.class, tableName, outputTable, Text.class, IntWritable.class, null, null, 1);
        HbaseInit.hbaseInit(hbaseJob);
    }
}
