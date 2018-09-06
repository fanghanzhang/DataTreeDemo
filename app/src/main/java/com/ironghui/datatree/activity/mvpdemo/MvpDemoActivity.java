package com.ironghui.datatree.activity.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.ironghui.datatree.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MvpDemoActivity extends AppCompatActivity implements ContactInterface.IView {
    @BindView(R.id.textview)
    TextView textview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);
        ButterKnife.bind(this);
        MyDemoPresenter presenter = new MyDemoPresenter(this);
        presenter.getDate();
    }

    @Override
    public void setView(String string) {
        textview.setText(string);
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }
}
