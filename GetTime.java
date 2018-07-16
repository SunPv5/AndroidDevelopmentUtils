package com.example.sp.androiddevelopmentutils.utils;

import java.text.SimpleDateFormat;

/**
 * Created by SP on 2018/6/7.
 * 获得当前系统时间工具类
 */

public class GetTime {

    public static String get_time(){
        SimpleDateFormat sDateFormat  = new SimpleDateFormat("yyyyMMddHHmmss");
        String date =  sDateFormat.format(new java.util.Date());
        return date;
    }
}
