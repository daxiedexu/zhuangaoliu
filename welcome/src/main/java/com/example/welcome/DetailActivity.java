package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.example.welcome.mvvm.entity.NewsDetailEntity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class DetailActivity extends AppCompatActivity {
    private WebView actDetailWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        actDetailWebView = (WebView) findViewById(R.id.act_detail_WebView);
        NewsDetailEntity.DataBean newsDetailEntity = getIntent().getParcelableExtra("detail");
        if (newsDetailEntity!=null){
            Log.d("hello",newsDetailEntity.getUrl());
            actDetailWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                    return super.shouldOverrideUrlLoading(webView, s);
                }
            });
            actDetailWebView.getSettings().setJavaScriptEnabled(true);
            actDetailWebView.loadUrl(newsDetailEntity.getUrl());
        }
    }
}
