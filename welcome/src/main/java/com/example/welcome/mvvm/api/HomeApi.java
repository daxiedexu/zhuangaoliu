package com.example.welcome.mvvm.api;

import androidx.lifecycle.LiveData;

import com.example.http.protocol.BaseRespEntity;
import com.example.welcome.mvvm.entity.GuideEntity;
import com.example.welcome.mvvm.entity.NewListEntity;
import com.example.welcome.mvvm.entity.NewsDetailEntity;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName HomeApi
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:19
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface HomeApi {
    @GET("api/NewsType/getAllTypes")
    LiveData<BaseRespEntity<ArrayList<GuideEntity>>> guide();
    @GET("api/News/getNews?")
    Observable<NewListEntity> newList(@Query("newstype") int newstype, @Query("pagenum") int pagenum, @Query("pagesize") int pagesize);
    @GET("api/NewsDetail/getNewsDetail?")
    LiveData<NewsDetailEntity> detail(@Query("newscode") String newscode);
}
