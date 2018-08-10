package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ironghui.datatree.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by ZhangFangHan on 2018/5/3.
 */

public class ButterknifeActivity extends AppCompatActivity {

    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    @BindView(R.id.fbt)
    FloatingActionButton fbt;
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.fbt, R.id.iv, R.id.bt, R.id.bt2, R.id.bt3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt3:
                Toast.makeText(getApplicationContext(), "点中bt3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt:
                Toast.makeText(getApplicationContext(), "点中按钮bt", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt2:
                Toast.makeText(getApplicationContext(), "点中按钮bt2", Toast.LENGTH_LONG).show();
                break;
            case R.id.fbt:
                Toast.makeText(getApplicationContext(), "点中按钮FBT", Toast.LENGTH_LONG).show();
                break;
            case R.id.iv:
                Toast.makeText(getApplicationContext(), "点中按钮Iv", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(getApplicationContext(), "超出点击范围", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}