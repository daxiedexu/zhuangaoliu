package com.example.welcome.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.common.ThreadUtils;
import com.example.mvvm_core.viewmodel.BaseViewModel;
import com.example.welcome.mvvm.entity.NewsDetailEntity;
import com.example.welcome.mvvm.repository.HomeRepository;

public class NewDetailViewModel extends BaseViewModel<HomeRepository> {
    public MutableLiveData<NewsDetailEntity> pageLiveData = new MutableLiveData<>();
    public NewDetailViewModel(LifecycleOwner owner) {
        super(owner);
        NewsDetailEntity newsDetailEntity = new NewsDetailEntity();
        if (ThreadUtils.isMainThread()){
            pageLiveData.setValue(newsDetailEntity);
        }else {
            pageLiveData.postValue(newsDetailEntity);
        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }

    public LiveData<NewsDetailEntity> detail(String newsCode){
         return mRepository.detail(newsCode);
    }
}
