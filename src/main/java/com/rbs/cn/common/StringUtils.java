package com.rbs.cn.common;

import java.util.regex.Pattern;

/**
 * Created by admin on 2018/1/12.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    /**
     * 分隔符类型,使用正则表达式,表示分隔符为\t或者,
     * 使用方法为SPARATOR.split(字符串)
     */
    public static final Pattern SPARATOR = Pattern.compile("[\t,]");

    /**
     * 判断
     */

}
