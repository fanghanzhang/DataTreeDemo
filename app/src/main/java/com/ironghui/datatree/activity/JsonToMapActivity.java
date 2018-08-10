package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ironghui.datatree.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JsonToMapActivity extends AppCompatActivity {

    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_red_img)
    ImageView ivRedImg;
    @BindView(R.id.tv_constents)
    TextView tvConstents;
    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = 3600;
    private static final long ONE_DAY = 86400;
    private static final long ONE_MONTH = 2592000;
    private static final long ONE_YEAR = 31104000;

    public static Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_mymsg);
        ButterKnife.bind(this);
//        initJsonToMap();
        /*Date date = new Date("2018-01-17 14:14:35");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
           Date date1 = format.parse("2018-01-17 14:14:35");
            testDate(date1);
//
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
//        tvConstents.setText( fromToday("2018-01-17 14:14:35"));
//        fromToday("2018-01-17 14:14:35");

    }

    private String testDate(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";

    }
    public static String fromToday(String timestr){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = df.parse(timestr);
        } catch (ParseException e) {
            e.printStackTrace();
            return "未知时间";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        long time = date.getTime() / 1000;
        long now = new Date().getTime() / 1000;
        long ago = now - time;
        if(ago <= ONE_HOUR){
            return ago / ONE_MINUTE + "分钟前";
        }
        else if(ago <= ONE_DAY){
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE)+ "分钟前";
        }
        else if(ago <= ONE_DAY * 2){
            return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点"+ calendar.get(Calendar.MINUTE) + "分";
        }
        else if (ago <= ONE_DAY * 3){
            return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        }
        else if (ago <= ONE_MONTH){
            long day = ago / ONE_DAY;
            if(day < 7)
                return day + "天前" ;
            else if (day >= 7 && day <14)
                return "1周前";
            else if (day >=14 && day <21)
                return "2周前";
            else if (day >= 21 && day <28)
                return "3周前";
            else
                return "4周前";
        }
        else if (ago <= ONE_YEAR){
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月" + day + "天前";
        }
        else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;// JANUARY which is 0 so month+1
            return year + "年前" + month + "月" + calendar.get(Calendar.DATE)
                    + "日";
        }
    }

    private void initJsonToMap() {
        String json = "{\"result\":\"000\",\"parentId\":902805256168013824,\"map\":{\"3\":\"待离职\",\"2\":\"正式员工\",\"1\":\"试用期\",\"0\":\"入职待审批\",\"6\":\"托管\",\"5\":\"退休\",\"4\":\"已离职\"},\"list\":[{\"createTime\":\"2018-01-17 14:14:35\",\"dicValName\":\"入职待审批\",\"dicvalId\":\"953510841943064576\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"0\"},{\"createTime\":\"2017-08-30 16:09:39\",\"dicValName\":\"试用期\",\"dicvalId\":\"902805498129022976\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"1\"},{\"createTime\":\"2017-08-30 16:09:50\",\"dicValName\":\"正式员工\",\"dicvalId\":\"902805544404779008\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"2\"},{\"createTime\":\"2017-08-30 16:09:59\",\"dicValName\":\"待离职\",\"dicvalId\":\"902805582082211840\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"3\"},{\"createTime\":\"2017-08-30 16:10:07\",\"dicValName\":\"已离职\",\"dicvalId\":\"902805617884790784\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"4\"},{\"createTime\":\"2017-08-30 16:10:17\",\"dicValName\":\"退休\",\"dicvalId\":\"902805659727167488\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"5\"},{\"createTime\":\"2018-01-16 15:20:39\",\"dicValName\":\"托管\",\"dicvalId\":\"953165080810225664\",\"memo\":\"\",\"parentId\":\"902805256168013824\",\"value\":\"6\"}],\"msg\":\"success\"}";
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            entry.getKey();
            entry.getValue();
        }

        Map<String, String> map1 = (Map<String, String>) map.get("map");
        String string = (String) map.get("result");
        for (Map.Entry<String, String> entryString : map1.entrySet()) {
            String key = entryString.getKey();
            String value = entryString.getValue();
        }
    }

}
