package com.example.welcome.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;

import com.example.common.utils.ThreadUtils;
import com.example.mvvm_core.viewmodel.BaseViewModel;
import com.example.welcome.mvvm.entity.GuideEntity;
import com.example.welcome.mvvm.repository.HomeRepository;

/**
 * @ClassName GuideViewModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/20 20:20
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class GuideViewModel extends BaseViewModel<HomeRepository> {
    public MutableLiveData<GuideEntity> mutableLiveData = new MutableLiveData<>();
    public GuideViewModel(LifecycleOwner owner) {
        super(owner);
        GuideEntity guideEntity = new GuideEntity();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(guideEntity);
        }else {
            mutableLiveData.postValue(guideEntity);
        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }
}
