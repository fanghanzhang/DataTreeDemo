package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ironghui.datatree.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;


/**
 * Created by ZhangFangHan on 2018/3/21.
 */

public class LoadGlide4 extends AppCompatActivity {

    private ImageView imageView;
    private boolean check;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadglide4);
        imageView = (ImageView) findViewById(R.id.image_view);
        button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });
    }

    public void loadImage() {

        String url = "http://guolin.tech/book.png";
      /*  Glide.with(this).load(url).override(200, 200).
                into(imageView);*/
        check = true;
        Snackbar.make(imageView, "data deleted", Snackbar.LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("点击的操作");
                    }
                })
                .show();

        String url2 = "http://guolin.tech/book.png";
       /* RequestOptions options = new RequestOptions()
                .transform(new BlurTransformation(), new GrayscaleTransformation());
        Glide.with(this)
                .load(url2)
                .apply(options)
                .into(imageView);*/
    }


}
