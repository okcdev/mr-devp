package com.rbs.cn.dim;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by fengtao.xue on 2018/1/12.
 */
public class DimMapper extends Mapper<LongWritable, Text, Text, Text>{

    Dim dim = new Dim();
    Text k = new Text();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //130	1300000	山东	济南	联通	250000	0531	370100	中国联通 GSM
        //String[] tokens = StringUtils.SPARATOR.split(value.toString());
        dim = Dim.parsePhoneRecord(value.toString());

        k.set(dim.getIsp());
        v.set(dim.getPre_7_num());
        context.write(k,v);

    }
}
