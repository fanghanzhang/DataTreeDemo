package com.ironghui.datatree.activity.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ironghui.datatree.R;
import com.ironghui.datatree.activity.BaseActivity;

/**
 * Created by ZhangFangHan on 2018/5/23.
 */

public class LoginMvpActivity extends BaseActivity implements ILoginInterface.IView{

    private TextView data_tv;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmvp);
        initView();
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        data_tv = findViewById(R.id.data_tv);
        data_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.loadData();
            }
        });
    }

    @Override
    public void setData(String strign) {
     data_tv.setText(strign);
    }
}
