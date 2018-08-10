package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ironghui.datatree.R;
import com.ironghui.datatree.adapter.ApproveProjectDetailAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by ZhangFangHan on 2018/5/7.   项目立项审批
 */

public class ApproveProjectDetail extends AppCompatActivity {

    @BindView(R.id.lv_approveproject)
    ListView lvApproveproject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approveprojectdetail);
        ButterKnife.bind(this);
        ApproveProjectDetailAdapter adapter = new ApproveProjectDetailAdapter();
        lvApproveproject.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
