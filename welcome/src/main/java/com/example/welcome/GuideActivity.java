package com.example.welcome;

import android.graphics.Color;

import androidx.lifecycle.Observer;
import com.example.common.utils.StatusBarColorUtils;
import com.example.http.RetrofitManger;
import com.example.http.protocol.BaseRespEntity;
import com.example.mvvm_core.view.BaseActivity;
import com.example.welcome.databinding.ActivityGuideBinding;
import com.example.welcome.mvvm.api.HomeApi;
import com.example.welcome.mvvm.entity.GuideEntity;
import com.example.welcome.mvvm.viewmodel.GuideViewModel;

import java.util.ArrayList;
import java.util.HashMap;

public class GuideActivity extends BaseActivity<GuideViewModel, ActivityGuideBinding> {
    @Override
    protected void initEvent() {
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .guide()
                .observe(GuideActivity.this, new Observer<BaseRespEntity<ArrayList<GuideEntity>>>() {
                    @Override
                    public void onChanged(BaseRespEntity<ArrayList<GuideEntity>> arrayListBaseRespEntity) {

                    }
                });
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(GuideActivity.this, Color.WHITE);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(GuideActivity.this,true);
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.GuideViewModel,mViewModel);
    }

    @Override
    protected GuideViewModel createViewModel() {
        return new GuideViewModel(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }
}
