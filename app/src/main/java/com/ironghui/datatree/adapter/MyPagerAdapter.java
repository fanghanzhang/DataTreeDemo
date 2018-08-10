package com.ironghui.datatree.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.Toast;

import com.ironghui.datatree.activity.MainActivity;
import com.ironghui.datatree.activity.VolleyActivity;

import java.util.List;

/**
 * Created by ZhangFangHan on 2018/4/28.
 */

public class MyPagerAdapter extends PagerAdapter {
    public static final int MAX_SCROLL_VALUE = 10000;
    private List<ImageView> mItems;
    private Context mContext;
    private LayoutInflater mInflater;

    public MyPagerAdapter(List<ImageView> items, Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret = null;
        //对ViewPager页号求摸取出View列表中要显示的项
        position %= mItems.size();
        Log.d("Adapter", "instantiateItem: position: " + position);
        ret = mItems.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent viewParent = ret.getParent();
        if (viewParent != null) {
            ViewGroup parent = (ViewGroup) viewParent;
            parent.removeView(ret);
        }

        container.addView(ret);

        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //警告:不要在这里调用removeView, 已经在instantiateItem中处理了
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (mItems.size() > 0) {
            ret = MAX_SCROLL_VALUE;
        }
        return ret;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }
}
