package com.example.welcome.mvvm.model.net;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.common.ThreadUtils;
import com.example.http.RetrofitManger;
import com.example.mvvm_core.model.IModel;
import com.example.welcome.mvvm.api.HomeApi;
import com.example.welcome.mvvm.entity.NewsDetailEntity;

public class NewDetailNetModel implements IModel {
    public LiveData<NewsDetailEntity> detail(String newsCode){
        MutableLiveData<NewsDetailEntity> mutableLiveData = new MutableLiveData<>();
        LiveData<NewsDetailEntity> ListData = RetrofitManger.getInstance().getRetrofit().create(HomeApi.class).detail(newsCode);
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(ListData.getValue());
        }else {
            mutableLiveData.postValue(ListData.getValue());
        }
        return mutableLiveData;
    }
}
