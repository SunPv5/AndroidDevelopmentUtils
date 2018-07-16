package com.example.sp.androiddevelopmentutils.utils;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

/**
 * Created by SP on 2018/6/7
 * 得到当前的手机蜂窝网络信号强度
 * 获取LTE网络和3G/2G网络的信号强度的方式有一点不同，
 * LTE网络强度是通过解析字符串获取的，
 * 3G/2G网络信号强度是通过API接口函数完成的。
 * asu 与 dbm 之间的换算关系是 dbm=-113 + 2*asu
 */


public class GetCurrentNetDBM {

    public static void getCurrentNetDBM(final Context context) {

        final TelephonyManager tm = (TelephonyManager) context
            .getSystemService(Context.TELEPHONY_SERVICE);

        PhoneStateListener mylistener = new PhoneStateListener() {
            @Override
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                super.onSignalStrengthsChanged(signalStrength);

                int asu = signalStrength.getGsmSignalStrength();
                int dbm = -113 + 2*asu;

              //  Log.e("dbm"," "+dbm);

                //通过广播将dbm值发送到需要它的地方
                Intent intent = new Intent("get_dbm");
                intent.putExtra("dbm",dbm);
                context.sendBroadcast(intent);
            }
        };

        tm.listen(mylistener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }
}























