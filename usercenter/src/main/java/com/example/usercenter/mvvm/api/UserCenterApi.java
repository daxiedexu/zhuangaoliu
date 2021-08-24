package com.example.usercenter.mvvm.api;

import androidx.lifecycle.LiveData;

import com.example.http.protocol.BaseRespEntity;
import com.example.usercenter.mvvm.entity.LoginEntity;
import com.example.usercenter.mvvm.entity.RegisterEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ClassName UserCenterApi
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 15:34
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface UserCenterApi {
    @POST("api/User/login")
    LiveData<BaseRespEntity<LoginEntity>> login(@Body LoginEntity entity);
    @POST("api/User/register")
    LiveData<BaseRespEntity<RegisterEntity>> register(@Body RegisterEntity entity);
}
