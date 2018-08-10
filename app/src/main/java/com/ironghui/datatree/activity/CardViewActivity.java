package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ironghui.datatree.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZhangFangHan on 2018/5/3.
 */

public class CardViewActivity extends AppCompatActivity {
   /* @BindView(R.id.tv_title)
    TextView tvTitle;*/
/*    @BindView(R.id.toolbar)
    Toolbar toolbar;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        ButterKnife.bind(this);
//        tvTitle.setText("2018年4月");

    }
}
