package com.example.sp.androiddevelopmentutils.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by SP on 2018/6/7.
 * 判断网络是否连接
 */

public class GetNet {

    public static boolean isConnect(Context context) {
        boolean connected = false;
        ConnectivityManager con = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();
        @SuppressLint("MissingPermission") boolean internet = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
        if (wifi | internet) {
            connected = true;
        }
        return connected;
    }
}
