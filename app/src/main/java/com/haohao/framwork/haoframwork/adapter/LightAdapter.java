package com.haohao.framwork.haoframwork.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.mvp.bean.MainListBean;

import java.util.List;

public class LightAdapter extends BaseQuickAdapter<MainListBean.DataBean, BaseViewHolder> {

    public LightAdapter(int layoutResId, @Nullable List<MainListBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainListBean.DataBean item) {
        helper.setText(R.id.tv1, "设备id: " + item.getData_id())
                .setText(R.id.tv2, "位置: " + item.getLocation())
                .setText(R.id.tv3, "环境温度: " + item.getTemp())
                .setText(R.id.tv4, "湿度: " + item.getRh())
                .setText(R.id.tv5, "光强: " + item.getLx())
                .setText(R.id.tv6, "电压: " + item.getVol())
                .setText(R.id.tv7, "电流: " + item.getCur())
                .setText(R.id.tv8, "当前时间: " + item.getTime());
    }
}
