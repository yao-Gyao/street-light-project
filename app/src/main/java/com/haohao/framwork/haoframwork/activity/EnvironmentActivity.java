package com.haohao.framwork.haoframwork.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.adapter.EnvAdapter;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.mvp.bean.EnvBean;
import com.haohao.framwork.haoframwork.mvp.presenter.EnvPresenter;
import com.haohao.framwork.haoframwork.mvp.view.EnvView;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentActivity extends BaseActivity implements EnvView {

    private RecyclerView rv;
    private EnvPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);
        mPresenter = new EnvPresenter(this,this);
        initView();
    }

    private void initView() {
        setStatusBar(true);
        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        int id = getIntent().getIntExtra("id", 0);
        Map<String,Object> map = new HashMap<>();
        map.put("dev_id",id);
        mPresenter.getList(map);
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
        EnvAdapter adapter = new EnvAdapter(R.layout.item_env,bean.getData());
        rv.setAdapter(adapter);
    }
}