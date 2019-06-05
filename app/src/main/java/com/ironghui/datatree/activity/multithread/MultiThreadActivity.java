package com.ironghui.datatree.activity.multithread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ironghui.datatree.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultiThreadActivity extends AppCompatActivity {

    @BindView(R.id.textview)
    TextView textview;
    @BindView(R.id.textview2)
    TextView textview2;
    @BindView(R.id.image_view)
    ImageView imageView;
    private ProgressDialog progressDialog;
    private final String IMAGE_PATH = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E5%88%98%E4%BA%A6%E8%8F%B2&hs=2&pn=2&spn=0&di=111870&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1236730268%2C667560409&os=2063326165%2C1981021372&simid=3361281948%2C100603710&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=star&bdtype=0&oriquery=%E5%88%98%E4%BA%A6%E8%8F%B2&objurl=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201511%2F27%2F20151127073259_CWQka.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B17tpwg2_z%26e3Bv54AzdH3Fks52AzdH3F%3Ft1%3D9ln8cc0m0&gsm=0&islist=&querylist=";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multithrea);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("提示信息");
        progressDialog.setMessage("正在下载，请稍后...");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        doBackground();
    }

    private void doBackground() {
        new MyAsyctask().execute(IMAGE_PATH);
    }

    /**
     * String 参数类型
     * Integer 执行任务的时候返回的类型
     * ArrayList<String> 返回的结果类型
     */
    class MyAsyctask extends AsyncTask<String, Integer, byte[]> {


        @Override
        protected byte[] doInBackground(String... strings) {

            return null;

        }

        @Override
        protected void onPostExecute(byte[] strings) {
            super.onPostExecute(strings);

        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
