package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ironghui.datatree.R;
import com.ironghui.datatree.adapter.MyPagerAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by ZhangFangHan on 2018/5/2.
 */

public class ViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnTouchListener{

    boolean isRunning = false;
    private ArrayList mItems;
    private android.support.v4.view.ViewPager mViewPager;
    private MyPagerAdapter mAdapter;
    private int currentViewPagerItem;
    private ImageView[] mBottomImages;
    public static final int VIEW_PAGER_DELAY = 2000;
    private LinearLayout mBottomLiner;
    private Thread mThread;
    private ViewPagerActivity.myHandler mHandler;
    private boolean isAutoPlay ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mHandler = new ViewPagerActivity.myHandler(this);
        mViewPager = findViewById(R.id.live_view_pager);
        mItems = new ArrayList<>();
        mAdapter = new MyPagerAdapter(mItems, getApplicationContext());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(this);
        mViewPager.setOnTouchListener(this);
        isAutoPlay=true;
        addImageView();
        mAdapter.notifyDataSetChanged();
        setBottomIndicator();

    }

    private void setBottomIndicator() {
        //获取指示器(下面三个小点)
        mBottomLiner = (LinearLayout) findViewById(R.id.live_indicator);
        //右下方小圆点
        mBottomImages = new ImageView[mItems.size()];
        for (int i = 0; i < mBottomImages.length; i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(10, 0, 5, 10);
            imageView.setLayoutParams(params);
            //如果当前是第一个 设置为选中状态
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_select);
            } else {
                imageView.setImageResource(R.drawable.indicator_no_select);
            }
            mBottomImages[i] = imageView;
            //添加到父容器
            mBottomLiner.addView(imageView);

        }

        //让其在最大值的中间开始滑动, 一定要在 mBottomImages初始化之前完成
        int mid = MyPagerAdapter.MAX_SCROLL_VALUE / 2;
        mViewPager.setCurrentItem(mid);
        currentViewPagerItem = mid;

        //定时发送消息
        mThread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    mHandler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(ViewPagerActivity.VIEW_PAGER_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        mThread.start();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Toast.makeText(this,"onPageScrolled",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageSelected(int position) {
        currentViewPagerItem = position;
        final int finalPosition = position;
        if (mItems != null) {
            position %= mBottomImages.length;
            int total = mBottomImages.length;

            for (int i = 0; i < total; i++) {
                if (i == position) {
                    mBottomImages[i].setImageResource(R.drawable.indicator_select);
                } else {
                    mBottomImages[i].setImageResource(R.drawable.indicator_no_select);
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        Toast.makeText(this,"onPageScrollStateChanged",Toast.LENGTH_SHORT).show();
    }

    private void addImageView() {
        ImageView view0 = new ImageView(this);
        view0.setImageResource(R.drawable.pic0);
        ImageView view1 = new ImageView(this);
        view1.setImageResource(R.drawable.pic1);
        ImageView view2 = new ImageView(this);
        view2.setImageResource(R.drawable.pic2);

        view0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        mItems.add(view0);
        mItems.add(view1);
        mItems.add(view2);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isAutoPlay = false;

                break;
            case MotionEvent.ACTION_UP:
                isAutoPlay = true;

                break;
        }
        return false;
    }

    private static class myHandler extends Handler {

        private final WeakReference weakReference;

        public myHandler(ViewPagerActivity viewPagerActivity) {
            weakReference = new WeakReference(viewPagerActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    ViewPagerActivity activity = (ViewPagerActivity) weakReference.get();
                    activity.mViewPager.setCurrentItem(++activity.currentViewPagerItem);//++activity是为了表示自动轮播
                    break;
            }
        }
    }
}
