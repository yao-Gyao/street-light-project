package com.haohao.framwork.haoframwork.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.mvp.bean.MainListBean;

import java.util.List;

import androidx.annotation.Nullable;

public class LightAdapter extends BaseQuickAdapter<MainListBean.MapBean.ListBean, BaseViewHolder> {

    public LightAdapter(int layoutResId, @Nullable List<MainListBean.MapBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainListBean.MapBean.ListBean item) {
        helper.setText(R.id.tv1, "设备id: " + item.getDev_id())
                .setText(R.id.tv2, "位置: " + item.getLocation());
    }
}
