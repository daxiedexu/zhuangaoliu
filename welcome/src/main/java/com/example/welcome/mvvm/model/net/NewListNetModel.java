package com.example.welcome.mvvm.model.net;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.common.utils.ThreadUtils;
import com.example.mvvm_core.model.IModel;
import com.example.welcome.mvvm.entity.NewListEntity;

/**
 * @ClassName NewListNetModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 19:23
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NewListNetModel implements IModel {
    public LiveData<NewListEntity> newList(NewListEntity newListEntity){
        MutableLiveData<NewListEntity> mutableLiveData = new MutableLiveData<>();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newListEntity);
        }else {
            mutableLiveData.postValue(newListEntity);
        }
        return mutableLiveData;
    }
}
