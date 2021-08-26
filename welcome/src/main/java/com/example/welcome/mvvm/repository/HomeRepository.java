package com.example.welcome.mvvm.repository;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.example.mvvm_core.model.Model;
import com.example.mvvm_core.repository.BaseRepository;
import com.example.welcome.mvvm.entity.GuideEntity;
import com.example.welcome.mvvm.entity.NewListEntity;
import com.example.welcome.mvvm.entity.NewsDetailEntity;
import com.example.welcome.mvvm.model.net.GuideNetModel;
import com.example.welcome.mvvm.model.net.NewDetailNetModel;
import com.example.welcome.mvvm.model.net.NewListNetModel;

/**
 * @ClassName HomeRepository
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:24
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeRepository extends BaseRepository {
    @Model
    GuideNetModel guideNetModel;
    @Model
    NewListNetModel newListNetModel;
    @Model
    NewDetailNetModel newDetailNetModel;
    public LiveData<GuideEntity> guide(GuideEntity guideEntity){
        return guideNetModel.guide(guideEntity);
    }
    public LiveData<NewListEntity> newList(NewListEntity newListEntity){
        return newListNetModel.newList(newListEntity);
    }
    public LiveData<NewsDetailEntity> detail( String newsCode){
        return newDetailNetModel.detail(newsCode);
    }
}
