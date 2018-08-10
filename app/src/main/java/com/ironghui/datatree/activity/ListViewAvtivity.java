package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ironghui.datatree.R;
import com.ironghui.datatree.adapter.ImaAdapterSoft;
import com.ironghui.datatree.adapter.ImageAdapter;
import com.ironghui.datatree.adapter.NetWorkImageAdapter;
import com.ironghui.datatree.utils.Images;

/**
 * Created by ZhangFangHan on 2018/3/26.
 */

public class ListViewAvtivity extends AppCompatActivity {

    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (ListView) findViewById(R.id.list_view);
//        ImageAdapter adapter = new ImageAdapter(this, 0, Images.imageUrls);
        ImaAdapterSoft imaAdapterSoft = new ImaAdapterSoft(this,0,Images.imageUrls);
//        NetWorkImageAdapter netWorkImageAdapter = new NetWorkImageAdapter(this, 0, Images.imageUrls);
        listView.setAdapter(imaAdapterSoft);
    }
}
