package com.ironghui.datatree.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ironghui.datatree.R;
import com.ironghui.datatree.interfacen.GetData;
import com.ironghui.datatree.interfacen.GetSecondData;
import com.ironghui.datatree.utils.GetDataUtils;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  GetSecondData {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        GetDataUtils.setGetSecondData(this);
        System.out.println("测试流程");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                GetDataUtils.returnData();
                startActivity();
                SecondActivity secondActivity = null;
                try {
                    secondActivity = new SecondActivity();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                secondActivity.setOnCaptchaMatchCallback(new SecondActivity.OnCaptchaMatchCallback() {
                    @Override
                    public void matchSuccess(String swipeCaptchaView) {
                        Toast.makeText(MainActivity.this, "matchSuccessonClick()", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void matchFailed(String swipeCaptchaView) {
                        Toast.makeText(MainActivity.this, "matchSuccessonClick()", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private static List<Activity> activityList = new ArrayList<Activity>();

    private void startActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void secondMethord() {
        System.out.println("secondMethord()回调成功");
    }

    @Override
    public void thirdMethord() {
        System.out.println("secondMethord()回调成功");
    }

}
