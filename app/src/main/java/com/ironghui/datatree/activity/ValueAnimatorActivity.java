package com.ironghui.datatree.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ironghui.datatree.R;

/**
 * Created by ZhangFangHan on 2018/3/30.
 */

public class ValueAnimatorActivity extends AppCompatActivity {

    private TextView textview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valueanimator);
        textview = (TextView) findViewById(R.id.tv);
//        ValueAnimator();
        objectAnimator();
    }

    private void objectAnimator() {
        /*ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();*/
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textview, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);//组合动画的顺序
        animSet.setDuration(5000);
        animSet.start();
    }

    private void ValueAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("TAG", "cuurent value is " + currentValue);
            }
        });
        anim.start();
    }
}
