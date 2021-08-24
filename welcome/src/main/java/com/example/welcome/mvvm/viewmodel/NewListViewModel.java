package com.example.welcome.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.example.common.utils.ThreadUtils;
import com.example.mvvm_core.viewmodel.BaseViewModel;
import com.example.welcome.mvvm.entity.NewListEntity;
import com.example.welcome.mvvm.repository.HomeRepository;

/**
 * @ClassName NewListLocalModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 20:21
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class NewListViewModel extends BaseViewModel<HomeRepository> {
    MutableLiveData<NewListEntity> mutableLiveData = new MutableLiveData<>();
    public NewListViewModel(LifecycleOwner owner) {
        super(owner);
        NewListEntity newListEntity = new NewListEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(newListEntity);
        }else {
            mutableLiveData.postValue(newListEntity);
        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }
}
