package com.haohao.framwork.haoframwork.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.mvp.bean.EnvBean;

import java.util.List;

public class EnvAdapter extends BaseQuickAdapter<EnvBean.DataBean, BaseViewHolder> {

    public EnvAdapter(int layoutResId, @Nullable List<EnvBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EnvBean.DataBean item) {
        helper.addOnClickListener(R.id.btn);
        helper.setText(R.id.tv1, "设备编号: " + item.getDev_id()+"")
                .setText(R.id.tv2, "温度: " + item.getTemp())
                .setText(R.id.tv3, "湿度: " + item.getHumd())
                .setText(R.id.tv4, "光照强度: " + item.getLight())
                .setText(R.id.tv5, "电流: " + item.getCurrent())
                .setText(R.id.tv6, "电压: " + item.getVoltage())
                .setText(R.id.tv7, "上传时间: " + item.getCreate_time())
        ;
    }
}
