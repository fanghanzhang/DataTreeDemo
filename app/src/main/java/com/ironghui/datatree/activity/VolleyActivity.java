package com.ironghui.datatree.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ironghui.datatree.DataBean.Weather;
import com.ironghui.datatree.DataBean.WeatherInfo;
import com.ironghui.datatree.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by ZhangFangHan on 2018/3/12.
 */

public class VolleyActivity extends AppCompatActivity {

    private StringRequest request;
    private JsonObjectRequest jsonObjectRequest;
    private JsonArrayRequest array;
    private ImageView iv;
    private ImageRequest imageRequest;
    private RequestQueue requestQueue;
    private NetworkImageView networkImageView;
    private ImageLoader imageLoader;

    /***
     * 1. 创建一个RequestQueue对象。
     * 2. 创建一个StringRequest对象。
     * 3. 将StringRequest对象添加到RequestQueue里面。
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024/1024);
        Log.d("TAG", "Max memory is " + maxMemory + "KB");
        iv = (ImageView) findViewById(R.id.iv);
        networkImageView = (NetworkImageView) findViewById(R.id.network_image_view);
        requestQueue = Volley.newRequestQueue(this);
//        getVolleyString();
//        getVolleyObjectString();
//        requestQueue.add(request);
//        requestQueue.add(jsonObjectRequest);
//        getVolleyArray();
//        getVolleyImage();
//        requestQueue.add(array);
//        requestQueue.add(imageRequest);
//        getVoleyImageLoader();
//        getVoleyNetWorkImageView();
        getVolleyXml();
//        getVolleyGson();
    }

    private void getVolleyGson() {
        GsonRequest<Weather> gsonRequest = new GsonRequest<Weather>(
                "http://www.weather.com.cn/data/sk/101010100.html", Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        WeatherInfo weatherInfo = weather.getWeatherinfo();
                        Log.d("TAG", "city is " + weatherInfo.getCity());
                        Log.d("TAG", "temp is " + weatherInfo.getTemp());
                        Log.d("TAG", "time is " + weatherInfo.getTime());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        requestQueue.add(gsonRequest);
    }

    private void getVolleyXml() {
        XMLRequest xmlRequest = new XMLRequest(
                "http://flash.weather.com.cn/wmaps/xml/china.xml",
                new Response.Listener<XmlPullParser>() {
                    @Override
                    public void onResponse(XmlPullParser response) {
                        try {
                            int eventType = response.getEventType();
                            while (eventType != XmlPullParser.END_DOCUMENT) {
                                switch (eventType) {
                                    case XmlPullParser.START_TAG:
                                        String nodeName = response.getName();
                                        if ("city".equals(nodeName)) {
                                            String pName = response.getAttributeValue(0);
                                            Log.d("TAG", "pName is " + pName);
                                        }
                                        break;
                                }
                                eventType = response.next();
                            }
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        requestQueue.add(xmlRequest);
    }

    private void getVoleyNetWorkImageView() {
        networkImageView.setDefaultImageResId(R.drawable.caijingweiyuanhui);
        networkImageView.setErrorImageResId(R.drawable.comm_error);
        networkImageView.setImageUrl("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg",
                imageLoader);
    }

    private void getVoleyImageLoader() {
        //第一位
        imageLoader = new ImageLoader(requestQueue, new BitmapCache()
        );
        ImageLoader.ImageListener listener = imageLoader.getImageListener(iv, R.drawable.caijingweiyuanhui, R.drawable.comm_error);
        imageLoader.get(" ", listener, 250, 200);//第二位

    }

    private void getVolleyImage() {
        imageRequest = new ImageRequest("http://pic.sogou.com/d?query=%E5%9B%BE%E7%89%87%E5%A4%A7%E5%85%A8%E9%A3%8E%E6%99%AF%E5%9B%BE%E7%89%87&ie=utf8&page=1&did=2&st=255&mode=255&phu=http%3A%2F%2Fimg16.3lian.com%2Fgif2016%2Fq21%2F28%2F21.jpg&p=40230500#did1"
                , new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                System.out.println(bitmap);
                iv.setImageBitmap(bitmap);

            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println(volleyError);
            }
        });
    }

    private void getVolleyArray() {
        String json = "['天津冷','北京暖','东京热','南京凉']";
        array = new JsonArrayRequest(json, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                System.out.println(jsonArray.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println(volleyError.toString());
            }
        });
    }

    private void getVolleyString() {
        request = new StringRequest("http://blog.csdn.net/guolin_blog/article/details/17482095/", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                System.out.println(s.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println(volleyError.toString());
            }
        });
    }

    private void getVolleyObjectString() {
        String response = "{'name':'lishuhao' }";
        jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
    }

    class BitmapCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            int maxSize = 10 * 1024 * 1024;
            mCache = new LruCache<String, Bitmap>(maxSize) {
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
