package com.rbs.cn.dim;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by fengtao.xue on 2018/1/13.
 */
public class DimReducer extends Reducer<Text, Text, Text, IntWritable>{

    IntWritable resCount = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Integer sum = 0;
        for (Text v : values){
            sum += 1;
        }
        resCount.set(sum);
        context.write(key, resCount);
    }
}
