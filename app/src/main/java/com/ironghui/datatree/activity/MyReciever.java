package com.ironghui.datatree.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ZhangFangHan on 2018/4/17.
 */

public class MyReciever extends BroadcastReceiver {
    private boolean islockScreen = false;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction()) ) {//当按下电源键，屏幕亮起的时候
            Toast.makeText(context, "/当按下电源键，屏幕亮起的时候", Toast.LENGTH_SHORT).show();
        }
        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction()) ) {//当按下电源键，屏幕变黑的时候
            islockScreen = true;
            Toast.makeText(context, "当按下电源键，屏幕变黑的时候", Toast.LENGTH_SHORT).show();
        }
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction()) ) {//当解除锁屏的时候
            islockScreen = false;
            Toast.makeText(context, "当解除锁屏的时候", Toast.LENGTH_SHORT).show();
        }
    }
}
