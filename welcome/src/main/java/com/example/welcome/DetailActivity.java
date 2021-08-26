package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.common.utils.StatusBarColorUtils;
import com.example.welcome.mvvm.entity.NewsDetailEntity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ScrollView;

public class DetailActivity extends AppCompatActivity {
    private TextView actDetailHeadTitle;
    private RelativeLayout headLayout;
    private TextView actDetailTitle;
    private ScrollView actDetailScrollView;
    private ImageView actDetailImage;
    private TextView actDetailAuthor;
    private TextView actDetailDate;
    private WebView actDetailWebView;
    private EditText actDetailWrite;
    private ImageView actDetailSay;
    private ImageView actDetailCollect;
    private ImageView actDetailUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(DetailActivity.this, Color.TRANSPARENT);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(DetailActivity.this,true);
        NewsDetailEntity.DataBean newsDetailEntity = getIntent().getParcelableExtra("detail");
        if (newsDetailEntity!=null){
            actDetailWebView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                    return super.shouldOverrideUrlLoading(webView, s);
                }
            });
            actDetailWebView.getSettings().setJavaScriptEnabled(true);
            actDetailHeadTitle.setText(newsDetailEntity.getTitle());
            actDetailTitle.setText(newsDetailEntity.getTitle());
            Glide.with(DetailActivity.this).load(R.mipmap.ic_launcher_round).into(actDetailImage);
            actDetailAuthor.setText(newsDetailEntity.getAuth());
            actDetailDate.setText(newsDetailEntity.getPublishtime());
            actDetailWebView.loadUrl(newsDetailEntity.getUrl());
        }
        actDetailScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_MOVE){
                    int height = headLayout.getHeight();
                    int scrollY = actDetailScrollView.getScrollY();
                    Log.i("word", ""+height);
                    Log.i("word", ""+scrollY);
                    if (scrollY>=height){
                        Log.d("word","超过了标题栏");
                        actDetailHeadTitle.setVisibility(View.VISIBLE);
                    }else {
                        actDetailHeadTitle.setVisibility(View.INVISIBLE);
                    }
                }
                return false;
            }
        });
    }

    private void initView() {
        actDetailWebView = (WebView) findViewById(R.id.act_detail_WebView);
        actDetailHeadTitle = (TextView) findViewById(R.id.act_detail_head_title);
        actDetailScrollView = (ScrollView) findViewById(R.id.act_detail_ScrollView);
        headLayout = (RelativeLayout) findViewById(R.id.head_layout);
        actDetailTitle = (TextView) findViewById(R.id.act_detail_title);
        actDetailImage = (ImageView) findViewById(R.id.act_detail_image);
        actDetailAuthor = (TextView) findViewById(R.id.act_detail_author);
        actDetailDate = (TextView) findViewById(R.id.act_detail_date);
        actDetailWrite = (EditText) findViewById(R.id.act_detail_write);
        actDetailSay = (ImageView) findViewById(R.id.act_detail_say);
        actDetailCollect = (ImageView) findViewById(R.id.act_detail_collect);
        actDetailUpload = (ImageView) findViewById(R.id.act_detail_upload);
    }
}
