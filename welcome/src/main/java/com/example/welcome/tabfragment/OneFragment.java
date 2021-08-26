package com.example.welcome.tabfragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.http.RetrofitManger;
import com.example.mvvm_core.view.BaseFragment;
import com.example.welcome.BR;
import com.example.welcome.DetailActivity;
import com.example.welcome.NewDetailsActivity;
import com.example.welcome.R;
import com.example.welcome.adapter.NewListAdapter;
import com.example.welcome.databinding.FragmentOneBinding;
import com.example.welcome.mvvm.api.HomeApi;
import com.example.welcome.mvvm.entity.NewListEntity;
import com.example.welcome.mvvm.entity.NewsDetailEntity;
import com.example.welcome.mvvm.viewmodel.NewListViewModel;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;

public class OneFragment extends BaseFragment<NewListViewModel, FragmentOneBinding> implements OnLoadMoreListener, OnRefreshListener,OnItemClickListener {
    private int pagenum = 1;
    private int index;
    private boolean isRefresh = false;
    private ViewStub fgOneViewStub;
    private RecyclerView fgOneRecycler;
    private SmartRefreshLayout fgOneSmart;
    private NewListAdapter newListAdapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==888){
                index=0;
                fgOneViewStub.setVisibility(View.GONE);
            }
        }
    };
    @Override
    protected void initEvent() {
        fgOneSmart = (SmartRefreshLayout) getActivity().findViewById(R.id.fg_one_smart);
        fgOneRecycler = (RecyclerView) getActivity().findViewById(R.id.fg_one_recycler);
        fgOneViewStub = (ViewStub) getActivity().findViewById(R.id.fg_one_viewStub);
        fgOneSmart.setOnLoadMoreListener(this::onLoadMore);
        fgOneSmart.setOnRefreshListener(this::onRefresh);
        initNet(1, pagenum, 10);
    }

    private void initNet(int newstype,int pagenum,int pagesize) {
        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
                .newList(newstype, pagenum, pagesize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewListEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewListEntity newListEntity) {
                        fgOneSmart.finishLoadMore();
                        fgOneSmart.finishRefresh();
                        for (int i = 0; i < newListEntity.getData().size(); i++) {
                            if (i%4==0){
                                newListEntity.getData().get(i).setItemtype(0);
                            }else if (i%4==1){
                                newListEntity.getData().get(i).setItemtype(1);
                            }else if (i%4==2){
                                newListEntity.getData().get(i).setItemtype(2);
                            }else {
                                newListEntity.getData().get(i).setItemtype(3);
                            }
                        }
                        initAdapter(newListEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initAdapter(NewListEntity newListEntity) {
        if (newListAdapter==null){
            newListAdapter = new NewListAdapter(newListEntity.getData());
            newListAdapter.setOnItemClickListener(this::onItemClick);
            fgOneRecycler.setAdapter(newListAdapter);
            fgOneRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        }else {
            if (isRefresh){
                newListAdapter.getData().clear();
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run()    {
                        index++;
                        if (index>=2){
                            timer.cancel();
                            handler.sendEmptyMessage(888);
                        }
                    }
                },0,1000);
            }
            newListAdapter.getData().addAll(newListEntity.getData());
            newListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.NewViewModel,mViewModel);
    }

    @Override
    protected NewListViewModel createViewModel() {
        return new NewListViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        Log.i("hello", "加载监听事件");
        pagenum++;
        isRefresh = false;
        initNet(1, pagenum, 10);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        Log.i("hello", "刷新监听事件");
        pagenum = 1;
        isRefresh = true;
        initNet(1, pagenum, 10);
        fgOneViewStub.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        NewListEntity.DataBean dataBean = (NewListEntity.DataBean) adapter.getItem(position);
        Log.d("hello",dataBean.getTitle());
        Intent intent = new Intent(getActivity(), NewDetailsActivity.class);
        intent.putExtra("newsCode",dataBean.getNewscode());
        startActivity(intent);
//        RetrofitManger.getInstance().getRetrofit().create(HomeApi.class)
//                .detail(dataBean.getNewscode())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<NewsDetailEntity>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(NewsDetailEntity newsDetailEntity) {
//                        Intent intent = new Intent(getActivity(), DetailActivity.class);
//                        intent.putExtra("detail",newsDetailEntity.getData());
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }
}
