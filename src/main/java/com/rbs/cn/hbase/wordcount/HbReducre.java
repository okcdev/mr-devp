package com.rbs.cn.hbase.wordcount;


import jdk.nashorn.internal.ir.annotations.Immutable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;

import javax.xml.soap.Text;
import java.io.IOException;

/**
 * Created by admin on 2018/1/26.
 */
public class HbReducre extends TableReducer<Text, IntWritable, ImmutableBytesWritable>{
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int i = 0;
        for (IntWritable val : values) {
            i += val.get();
        }
        Put put = new Put(Bytes.toBytes(key.toString()));
        put.add(Bytes.toBytes("cf"), Bytes.toBytes("count"), Bytes.toBytes(i));

        context.write(null, put);
    }
}
