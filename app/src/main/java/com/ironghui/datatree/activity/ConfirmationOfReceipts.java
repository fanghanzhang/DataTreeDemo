package com.ironghui.datatree.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ironghui.datatree.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmationOfReceipts extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_mymsg);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
      /*  tvTitle.setText("确认领款");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getApplicationContext()).onBackPressed();
            }
        });*/
    }
}
