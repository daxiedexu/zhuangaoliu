package com.example.usercenter;

import android.content.Intent;
import android.graphics.Color;
import android.widget.Toast;
import androidx.lifecycle.Observer;

import com.example.common.utils.StatusBarColorUtils;
import com.example.http.RetrofitManger;
import com.example.http.protocol.BaseRespEntity;
import com.example.mvvm_core.view.BaseActivity;
import com.example.usercenter.databinding.ActivityLoginBinding;
import com.example.usercenter.mvvm.api.UserCenterApi;
import com.example.usercenter.mvvm.entity.LoginEntity;
import com.example.usercenter.mvvm.viewmodel.LoginViewModel;
import com.example.welcome.HomeActivity;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {
    @Override
    protected void initEvent() {
        mBinding.setLoginOnClick(view->{
            /**
             * RxJava解决点击事件抖动
             */
            RxView.clicks(view).throttleFirst(3, TimeUnit.SECONDS)
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            RetrofitManger.getInstance()
                                    .getRetrofit()
                                    .create(UserCenterApi.class)
                                    .login(mViewModel.mutableLiveData.getValue())
                                    .observe(LoginActivity.this, new Observer<BaseRespEntity<LoginEntity>>() {
                                        @Override
                                        public void onChanged(BaseRespEntity<LoginEntity> loginEntityBaseRespEntity) {
                                            if (loginEntityBaseRespEntity.getCode()==200){
                                                Toast.makeText(LoginActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                                startActivity(intent);
                                            }
                                        }
                                    });
                        }
                    });
        });
        mBinding.setSkipOnClick(view->{
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
        /**
         * 更改状态栏、字体颜色
         */
        StatusBarColorUtils.setStatusBarColor(LoginActivity.this,Color.WHITE);
        StatusBarColorUtils.setAndroidNativeLightStatusBar(LoginActivity.this,true);
    }
    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.LoginViewModel,mViewModel);
    }
    @Override
    protected LoginViewModel createViewModel() {
        return new LoginViewModel(this);
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }
}