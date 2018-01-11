package com.rbs.had;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by admin on 2018/1/11.
 */
public class MRReducer extends Reducer<Text, Text, Text, Text> {

    static org.slf4j.Logger logger = LoggerFactory.getLogger(MRReducer.class);

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        logger.debug("reduce input key:{}", key);
        logger.debug("reduce input value:{}", values);
        int maxValue = Integer.MIN_VALUE;
        StringBuffer sb = new StringBuffer();
        //取values的最大值
        for (Text value : values) {
            maxValue = Math.max(maxValue, Integer.parseInt(value.toString()));
            sb.append(value).append(", ");
        }
        context.write(key, new Text(Integer.toString(maxValue)));
    }
}
