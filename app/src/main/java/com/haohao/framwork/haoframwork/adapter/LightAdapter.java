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
        helper.setText(R.id.tv1, "id: " + item.getData_id())
                .setText(R.id.tv2, "位置: " + item.getLocation())
                .setText(R.id.tv3, "temp: " + item.getTemp())
                .setText(R.id.tv4, "rh: " + item.getRh())
                .setText(R.id.tv5, "lx: " + item.getLx())
                .setText(R.id.tv6, "vol: " + item.getVol())
                .setText(R.id.tv7, "cur: " + item.getCur())
                .setText(R.id.tv8, "time: " + item.getTime());
    }
}
