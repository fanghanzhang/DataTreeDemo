package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ironghui.datatree.R;

/**
 * Created by ZhangFangHan on 2018/3/18.
 */

public class LoadGlide extends AppCompatActivity {
    private ImageView imageView;
    private String uri2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadglide);
        uri2 = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=jpg%E5%9B%BE%E7%89%87&hs=2&pn=5&spn=0&di=22587583040&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1378996656%2C884808276&os=4099281411%2C2808118315&simid=4277930249%2C863585908&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=jpg%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F10%2F82%2Fb7830414976d.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bvxp7h7_z%26e3Bv54AzdH3Frtv_8abd0bn_z%26e3Bip4s&gsm=0";
        imageView = (ImageView) findViewById(R.id.image_view);
    }

    public void loadImage(View view) {
        String url = "http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg";
        Glide.with(this).load(url).into(imageView);
      /*  int resource = R.drawable.caijingweiyuanhui;
        Glide.with(this).load(resource).into(imageView);*/

    }
}
