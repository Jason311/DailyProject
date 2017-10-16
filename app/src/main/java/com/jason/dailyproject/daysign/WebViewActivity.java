package com.jason.dailyproject.daysign;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jason.dailyproject.R;

/**
 * 创建日期: 2017/10/16 on 下午11:47
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class WebViewActivity extends AppCompatActivity {

    private TextView titleTv;
    private WebView mWebView;
    private ProgressBar progress;

    //跳转的url
    private String url;

    /**
     * Override
     *
     * @param savedInstanceState _
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        titleTv = (TextView) findViewById(R.id.title_tv);
        mWebView = (WebView) findViewById(R.id.webView);
        progress = (ProgressBar) findViewById(R.id.progress);

        titleTv.setText("加载中");
        initWebView(mWebView);

        if (getIntent() == null) {
            finish();
        }
        //跳转的url
        url = getIntent().getStringExtra("url");
        mWebView.loadUrl(url);
    }


    @SuppressLint("SetJavaScriptEnabled")
    public void initWebView(WebView webView) {
        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                result.cancel();
                return false;
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                titleTv.setText(title);
            }

        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else {
                    view.loadUrl(url); // 在当前的webview中跳转到新的url
                }

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (!isFinishing()) {

                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progress != null) {
                    progress.setVisibility(View.GONE);
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
