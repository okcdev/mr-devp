package com.rbs.cn.hbase.wordcount;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * Created by admin on 2018/1/26.
 */
public class HbMapper extends TableMapper<Text, IntWritable> {
    private final IntWritable ONE = new IntWritable(1);
    private Text text = new Text();

    public void map(ImmutableBytesWritable row, Result value, Context context) throws IOException, InterruptedException {
        String val = new String(value.getValue(Bytes.toBytes("cf"), Bytes.toBytes("attr1")));
        text.set(val);     // we can only emit Writables...

        context.write(text, ONE);
    }
}
