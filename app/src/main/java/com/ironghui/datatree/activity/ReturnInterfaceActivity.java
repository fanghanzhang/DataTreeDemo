package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ironghui.datatree.R;
import com.ironghui.datatree.interfacen.GetData;
import com.ironghui.datatree.interfacen.GetSecondData;
import com.ironghui.datatree.interfacen.GetThirdData;
import com.ironghui.datatree.utils.GetDataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZhangFangHan on 2018/5/23.
 */

public class ReturnInterfaceActivity extends BaseActivity implements GetData, GetSecondData, GetThirdData {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.bt)
    Button bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returninterface);
        ButterKnife.bind(this);
        GetDataUtils.setGetDate(this);
        GetDataUtils.setGetSecondData(this);
        GetDataUtils.setGetThirdData(this);
    }

    @OnClick({R.id.tv, R.id.bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                GetDataUtils.returnData();
                break;
            case R.id.bt:
//                GetDataUtils.returnSecondData();
                GetDataUtils.returnThirdData();
                break;
        }
    }
    @Override
    public void onEnd(String string) {
        System.out.println("onEnd()回调成功");
    }

    @Override
    public void onStartde(String abc) {
        System.out.println("onStarted()回调成功");
    }

    @Override
    public void secondMethord() {
        System.out.print("调用secondMethord()成功");
    }

    @Override
    public void thirdMethord() {
        System.out.print("调用thirdMethord()成功");
    }

    @Override
    public void getThirdData() {
        System.out.print("调用getThirdData()成功");
    }

    @Override
    public void setThirdData() {
        System.out.print("调用setThirdData()成功");
    }
}
