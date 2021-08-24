package com.example.usercenter.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.common.utils.ThreadUtils;
import com.example.mvvm_core.model.IModel;
import com.example.usercenter.mvvm.entity.LoginEntity;

/**
 * @ClassName LoginNetModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 15:39
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class LoginNetModel implements IModel {
    public LiveData<LoginEntity> login(LoginEntity loginEntity){
        MutableLiveData<LoginEntity> entityMutableLiveData = new MutableLiveData<>();
        if (ThreadUtils.isMainThread()){
            entityMutableLiveData.setValue(loginEntity);
        }else {
            entityMutableLiveData.postValue(loginEntity);
        }
        return entityMutableLiveData;
    }
}
