package com.example.welcome.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.welcome.R;
import com.example.welcome.mvvm.entity.NewListEntity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NewListAdapter extends BaseMultiItemQuickAdapter<NewListEntity.DataBean, BaseViewHolder> {
    public NewListAdapter(@Nullable List<NewListEntity.DataBean> data) {
        super(data);
        addItemType(0 ,R.layout.news_item_first);
        addItemType(1, R.layout.news_item_second);
        addItemType(2, R.layout.news_item_third);
        addItemType(3, R.layout.news_item_fourth);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewListEntity.DataBean dataBean) {
        switch (dataBean.getItemType()){
            case 0:
                baseViewHolder.setText(R.id.item_one_tv_title,dataBean.getTitle());
                baseViewHolder.setText(R.id.item_one_tv_sourcesitename,dataBean.getSourcesitename());
                break;
            case 1:
                baseViewHolder.setText(R.id.item_two_tv_title,dataBean.getTitle());
                baseViewHolder.setText(R.id.item_two_tv_sourcesitename,dataBean.getSourcesitename());
                Glide.with(getContext()).load(dataBean.getMainimgurl()+".jpg").into((ImageView) baseViewHolder.getView(R.id.item_two_iv_mainimgurl));
                break;
            case 2:
                baseViewHolder.setText(R.id.item_three_tv_title,dataBean.getTitle());
                baseViewHolder.setText(R.id.item_three_tv_sourcesitename,dataBean.getSourcesitename());
                Glide.with(getContext()).load(dataBean.getMainimgurl()+".jpg").into((ImageView) baseViewHolder.getView(R.id.item_three_iv_mainimgurl));
                break;
            case 3:
                baseViewHolder.setText(R.id.item_four_tv_title,dataBean.getTitle());
                baseViewHolder.setText(R.id.item_four_tv_sourcesitename,dataBean.getSourcesitename());
                Glide.with(getContext()).load(dataBean.getMainimgurl()+".jpg").into((ImageView) baseViewHolder.getView(R.id.item_four_iv_mainimgurl_one));
                Glide.with(getContext()).load(dataBean.getMainimgurl()+".jpg").into((ImageView) baseViewHolder.getView(R.id.item_four_iv_mainimgurl_two));
                Glide.with(getContext()).load(dataBean.getMainimgurl()+".jpg").into((ImageView) baseViewHolder.getView(R.id.item_four_iv_mainimgurl_three));
                break;
        }
    }
}
