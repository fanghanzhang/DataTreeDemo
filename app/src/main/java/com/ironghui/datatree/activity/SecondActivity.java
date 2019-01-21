package com.ironghui.datatree.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ironghui.datatree.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.ironghui.datatree.utils.GetDataUtils.returnData;

/**
 * Created by ZhangFangHan on 2018/3/5.
 */
public class SecondActivity extends AppCompatActivity {
    public SecondActivity() throws MalformedURLException {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setcond);
//        returnData();
        setEnd();
//        returnSecondData();
//        testHttpUrlConnection();
    }

    private void testHttpUrlConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://blog.csdn.net/u010566681/article/details/52371359");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    // 设置请求方式
                    connection.setRequestMethod("GET");
                    // 设置是否使用缓存
                    connection.setUseCaches(true);
                    // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
                    connection.setInstanceFollowRedirects(true);
                    // 设置超时时间
                    connection.setConnectTimeout(3000);
                    // 连接
                    connection.connect();
                    // 4. 得到响应状态码的返回值 responseCode
                    int code = connection.getResponseCode();
                    // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
                    String msg = "";
                    if (code == 200) { // 正常响应
                        // 从流中读取响应信息
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(connection.getInputStream()));
                        String line = null;

                        while ((line = reader.readLine()) != null) { // 循环从流中读取
                            msg += line + "\n";
                        }
                        reader.close(); // 关闭流
                    }
                    // 6. 断开连接，释放资源
                    connection.disconnect();

                    // 显示响应结果
                    System.out.println(msg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public interface OnCaptchaMatchCallback {
        void matchSuccess(String swipeCaptchaView);

        void matchFailed(String swipeCaptchaView);
    }

    private static OnCaptchaMatchCallback mOnCaptchaMatchCallback;

    public static void setOnCaptchaMatchCallback(OnCaptchaMatchCallback onCaptchaMatchCallback) {
        mOnCaptchaMatchCallback = onCaptchaMatchCallback;

    }


    public static void setEnd() {
        mOnCaptchaMatchCallback.matchFailed("matchFailed");
        mOnCaptchaMatchCallback.matchSuccess("matchSuccess");
    }
}
