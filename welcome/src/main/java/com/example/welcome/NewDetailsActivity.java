package com.example.welcome;


import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.mvvm_core.view.BaseActivity;
import com.example.welcome.databinding.ActivityNewDetailsBinding;
import com.example.welcome.mvvm.entity.NewsDetailEntity;
import com.example.welcome.mvvm.viewmodel.NewDetailViewModel;

import java.util.HashMap;

public class NewDetailsActivity extends BaseActivity<NewDetailViewModel, ActivityNewDetailsBinding> {
    private static final String TAG = "NewDetailsActivity";
    @Override
    protected void initEvent() {
        String newsCode = getIntent().getStringExtra("newsCode");
        if (newsCode!=null){
            Log.i(TAG, "传递过来的数据："+newsCode);
            mViewModel.detail(newsCode).observe(this, new Observer<NewsDetailEntity>() {
                @Override
                public void onChanged(NewsDetailEntity newsDetailEntity) {
                    Toast.makeText(NewDetailsActivity.this, newsDetailEntity.getData().getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.DetailViewModel,mViewModel);
    }

    @Override
    protected NewDetailViewModel createViewModel() {
        return new NewDetailViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_new_details;
    }
}
