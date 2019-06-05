package com.ironghui.datatree.activity.multithread;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ironghui.datatree.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.utils.Log;

public class HandlerActivity extends AppCompatActivity {
    @BindView(R.id.textview)
    TextView textview;
    @BindView(R.id.textview2)
    TextView textview2;
    HandlerThread thread = new HandlerThread("thread");
    private static Handler handler = new Handler();
    Handler handlertwo = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String string = (String) msg.obj;
                textview2.setText("message+消息" + string);
            }
            if (msg.what == 2) {
                String string = (String) msg.obj;
                textview2.setText("sendtotarget+消息" + string);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multithrea);
        ButterKnife.bind(this);
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("提示信息");
        dialog.setMessage("正在下载，请稍后...");
        dialog.setCancelable(false);
//        initHandler();
        Threadone threadone = new Threadone("one");
        Threadone threadtwo = new Threadone("two");
        Threadone threadthree = new Threadone("three");
        Threadone threadtfour = new Threadone("foure");
        threadone.setName("one");
        threadtwo.setName("two");
        threadthree.setName("three");
        threadtfour.setName("four");
        int threadCount = 3;
        int max = 100;
       /* for (int i = 0; i < threadCount; i++) {
            new Thread(new ThreeThreadPrintActivity(i, threadCount, max)).start();
        }*/
       /* for (int i = 1; i <= 3; i++) {//传入对象锁 和 i值

            new Thread(new ThreeThreadPrintActivity2(i), "线程" + i).start();
        }*/
       /*final ThreeThreadPrint3 threadPrint3 = new ThreeThreadPrint3();
        //循环建立三个线程.并启动
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        threadPrint3.print(Thread.currentThread().getName());
                    }
                }
            }, i + "").start();

        }*/
        int num = numSum("A-1B--2C--D6ELSGB--GMNIEW--89");
//        threadone.start();
//        threadtwo.start();
//        threadthree.start();
        try {
            threadone.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadtfour.start();
//        System.out.println("main end结束");
//        new Thread(threadone, "窗口一").start();
//        new Thread(threadone, "窗口二").start();
//        new Thread(threadone, "窗口三").start();
//       new Thread(threadone,"窗口四").start();
    }


    private void initHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("子线程数据", Thread.currentThread().getName());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textview.setText("发送给主线程更改ui数据");
                        Log.d("主线程", Thread.currentThread().getName());
                    }
                });
                Message msg = Message.obtain();
                msg.obj = "message返回携带的数据";
                msg.what = 2;
                // 发送这个消息到消息队列中
//                handlertwo.sendMessage(msg);
                msg.sendToTarget();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();
    }

    class Threadone extends Thread {
        String name;
        private int ticket = 80;

        public Threadone(String name) {
            this.name = name;
        }

        public void run() {

            for (int i = 0; i < 80; i++) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":ticket" + this.ticket--);
                }
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }

    }

    public int numSum(String str) {
        //如果字符串为null或者字符串的长度为零，返回0；
        if (str == null || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            cur = chars[i] - '0';
            //判断当前字符是否为数字
            if (cur >= 0 && cur <= 9) {
                //数字增加一位
                num = num * 10 + (posi ? cur : -cur);
            } else {
                //一旦遇到了非数字，那么就将当前数字加到结果res上
                res += num;
                num = 0;
                //如果不是负号
                if (chars[i] != '-') {
                    posi = true;
                } else {
                    //是负号，但是仍要判断当前字符是否是第一个字符||前一个字符是否是负号
                    if (i == 0 || chars[i - 1] != '-') {
                        posi = false;
                    } else
                        posi = !posi;
                }
            }
        }
        System.out.println(res + "运行结果");
        return res;
    }

}
