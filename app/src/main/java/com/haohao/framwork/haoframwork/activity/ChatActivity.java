package com.haohao.framwork.haoframwork.activity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.mvp.bean.EnvBean;
import com.haohao.framwork.haoframwork.mvp.presenter.EnvPresenter;
import com.haohao.framwork.haoframwork.mvp.view.EnvView;
import com.haohao.framwork.haoframwork.utils.HaoChartStyleOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatActivity extends BaseActivity implements EnvView {

    private EnvPresenter mPresenter;
    private LineChart chat1;
    private LineChart chat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mPresenter = new EnvPresenter(this, this);
        initView();
    }

    private void initView() {
        setStatusBar(true);

        int id = getIntent().getIntExtra("id", 0);
        Map<String, Object> map = new HashMap<>();
        map.put("dev_id", id);
        mPresenter.getList(map);
        chat1 = (LineChart) findViewById(R.id.chat1);
        chat2 = (LineChart) findViewById(R.id.chat2);
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void updateView(EnvBean bean) {
        if (bean == null || bean.getData() == null)
            return;
        List<EnvBean.DataBean> data = bean.getData();
        List<String> mXValue = new ArrayList<>();
        List<String> mXValue1 = new ArrayList<>();
        List<List<Float>> list = new ArrayList<>();
        List<List<Float>> list1 = new ArrayList<>();
        List<Float> mYValue = new ArrayList<>();
        List<Float> mYValue1 = new ArrayList<>();
        for(int i = 0; i < data.size(); i++) {
            mXValue.add(data.get(i).getDev_id()+"");
            mXValue1.add(data.get(i).getDev_id()+"");
            mYValue.add(Float.parseFloat(data.get(i).getCurrent()));
            mYValue1.add(Float.parseFloat(data.get(i).getVoltage()));
        }
        list.add(mYValue);
        list1.add(mYValue1);
        HaoChartStyleOne.setLinesChart(this, chat1, mXValue, list, new int[]{R.color.main_blue}, false);
        HaoChartStyleOne.setLinesChart(this, chat2, mXValue1, list1, new int[]{R.color.main_blue}, false);

    }
}