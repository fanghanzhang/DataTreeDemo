package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ironghui.datatree.R;
import com.yanzhenjie.sofia.Sofia;
import com.zhy.autolayout.AutoLayoutActivity;

public class ShiPeeActivity extends AutoLayoutActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipei);
        liuhaiping();
    }

    private void liuhaiping() {

        Sofia.with(this).
                statusBarBackgroundAlpha(0)
                .invasionStatusBar()
                .invasionNavigationBar();
    }
}
