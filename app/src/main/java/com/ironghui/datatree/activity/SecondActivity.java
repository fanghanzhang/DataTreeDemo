package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ironghui.datatree.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.ironghui.datatree.utils.GetDataUtils.returnData;

/**
 * Created by ZhangFangHan on 2018/3/5.
 */
public class SecondActivity extends AppCompatActivity {
    public SecondActivity() throws MalformedURLException {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setcond);
        returnData();
        setEnd();
//        returnSecondData();
    }

    public interface OnCaptchaMatchCallback {
        void matchSuccess(String swipeCaptchaView);

        void matchFailed(String swipeCaptchaView);
    }

    private static OnCaptchaMatchCallback mOnCaptchaMatchCallback;

    public static void setOnCaptchaMatchCallback(OnCaptchaMatchCallback onCaptchaMatchCallback) {
        mOnCaptchaMatchCallback = onCaptchaMatchCallback;

    }


    public static void setEnd() {
        mOnCaptchaMatchCallback.matchFailed("matchFailed");
        mOnCaptchaMatchCallback.matchSuccess("matchSuccess");
    }
}
