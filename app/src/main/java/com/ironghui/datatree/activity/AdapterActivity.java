package com.ironghui.datatree.activity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.ironghui.datatree.DataBean.Contact;
import com.ironghui.datatree.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZhangFangHan on 2018/5/14.
 */

public class AdapterActivity extends BaseActivity {

    private ListView mListView;
    private SimpleAdapter mAdapter;
    private List<HashMap<String, Object>> mHashMaps;
    private HashMap<String, Object> map;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        mListView = findViewById(R.id.lv);
//        SimpleAdapter   mAdapter = new SimpleAdapter(this, getData(), R.layout.simpleitem, new String[]{"image", "title", "info"}, new int[]{R.id.img, R.id.title, R.id.info});
//        mListView.setAdapter(mAdapter);
//        mListView.setAdapter(new BaseListAdapter(this));
        getContact(this);
    }



    private List<HashMap<String, Object>> getData() {
        mHashMaps = new ArrayList<HashMap<String, Object>>();
        map = new HashMap<String, Object>();
        map.put("image", R.drawable.ellipse);
        map.put("title", "G1");
        map.put("info", "google 1");
        mHashMaps.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.hyzl_app_img);
        map.put("title", "G2");
        map.put("info", "google 2");
        mHashMaps.add(map);

        map = new HashMap<String, Object>();
        map.put("image", R.drawable.hyzl_app_img);
        map.put("title", "G3");
        map.put("info", "google 3");

        mHashMaps.add(map);
        return mHashMaps;
    }
    private class BaseListAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater inflater;

        public BaseListAdapter(Context mContext) {
            this.mContext = mContext;
            inflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return getData().size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.testbaseadapter, null);
                viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
                viewHolder.title = (TextView) convertView.findViewById(R.id.title);
                viewHolder.info = (TextView) convertView.findViewById(R.id.info);
                viewHolder.button = (Button) convertView.findViewById(R.id.basebutton);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            System.out.println("viewHolder = " + viewHolder);
            viewHolder.img.setBackgroundResource((Integer) getData().get(position).get("image"));
            viewHolder.title.setText((CharSequence) getData().get(position).get("title"));
            viewHolder.info.setText((CharSequence) getData().get(position).get("info"));
            return convertView;
        }

        class ViewHolder {
            ImageView img;
            TextView title;
            TextView info;
            Button button;
        }


    }
    Cursor c;

    public ArrayList<Contact> getContact(Activity context) {
        ArrayList<Contact> listMembers = new ArrayList<Contact>();
        Cursor cursor = null;
        try {

            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            // 这里是获取联系人表的电话里的信息  包括：名字，名字拼音，联系人id,电话号码；
            // 然后在根据"sort-key"排序
            cursor = context.getContentResolver().query(
                    uri,
                    new String[] { "display_name", "sort_key", "contact_id",
                            "data1" }, null, null, "sort_key");

            if (cursor.moveToFirst()) {
                do {
                    Contact contact = new Contact();
                    String contact_phone = cursor
                            .getString(cursor
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    String name = cursor.getString(0);
                    String sortKey = getSortKey(cursor.getString(1));
                    int contact_id = cursor
                            .getInt(cursor
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                    contact.contact_name = name;
                    contact.sortKey = sortKey;
                    contact.contact_phone = contact_phone;
                    contact.setContact_id(contact_id);
                    if (name != null)
                        listMembers.add(contact);
                } while (cursor.moveToNext());
                c = cursor;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context = null;
        }
        return listMembers;
    }
    private static String getSortKey(String sortKeyString) {
        String key = sortKeyString.substring(0, 1).toUpperCase();
        if (key.matches("[A-Z]")) {
            return key;
        }
        return "#";
    }
}

