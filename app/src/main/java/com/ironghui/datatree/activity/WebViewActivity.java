package com.ironghui.datatree.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.ironghui.datatree.R;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar mProgress;
    private VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
//        initView();
        playVideo();
    }

    private void initView() {

        mProgress = (ProgressBar) findViewById(R.id.mProgress);
        webView = findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
      /*  webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
         webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
         webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDomStorageEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebViewClient());
        webView.loadUrl("https://www.baidu.com");*/
        //支持js
        webView.getSettings().setJavaScriptEnabled(true);
        //支持缩放
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        //接口回调
        webView.setWebChromeClient(new WebViewClient());
        //加载网页
        webView.loadUrl("https://www.baidu.com");
        new android.webkit.WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl("https://www.baidu.com");
                return true;
            }
        };

    }
    private void playVideo() {

        videoView = (VideoView) findViewById(R.id.vidio_view);
        Uri uri = Uri.parse("https://v.qq.com/x/cover/33bfp8mmgakf0gi.html");
        videoView.setVideoURI(uri);

        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        //videoView.setVideoPath(path);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //设置快进的倍速
                mediaPlayer.setPlaybackSpeed(1.0f);
                //设置缓冲大小
                mediaPlayer.setBufferSize(512 * 1024);
            }
        });
        videoView.start();
    }
    public class WebViewClient extends WebChromeClient {
        //进度变化监听

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgress.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
}
