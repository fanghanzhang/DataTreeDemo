package com.ironghui.datatree.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.ironghui.datatree.R;

/**
 * Created by ZhangFangHan on 2018/3/26.
 */

public class NetWorkImageAdapter extends ArrayAdapter {
    ImageLoader mImageLoader;

    public NetWorkImageAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        RequestQueue queue = Volley.newRequestQueue(context);
        mImageLoader = new ImageLoader(queue, new BitmapCache());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String url = (String) getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.image_item_volley, null);
        } else {
            view = convertView;
        }
        NetworkImageView image = (NetworkImageView) view.findViewById(R.id.image);
        image.setDefaultImageResId(R.drawable.caijingweiyuanhui);
        image.setErrorImageResId(R.drawable.comm_error);
        image.setImageUrl(url, mImageLoader);
        return view;
    }

    /**
     * 使用LruCache来缓存图片
     */
    public class BitmapCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            System.out.println("free:" + Runtime.getRuntime().freeMemory() / 1024 / 1024);
            // 获取应用程序最大可用内存
            int maxMemory = (int) Runtime.getRuntime().maxMemory();
            int cacheSize = maxMemory / 8;

            mCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }
}
