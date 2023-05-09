package com.haohao.framwork.haoframwork.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.activity.ChatActivity;
import com.haohao.framwork.haoframwork.adapter.LightAdapter;
import com.haohao.framwork.haoframwork.framwork.BaseFragment;
import com.haohao.framwork.haoframwork.mvp.bean.MainListBean;
import com.haohao.framwork.haoframwork.mvp.presenter.MainPresenter;
import com.haohao.framwork.haoframwork.mvp.view.ExpressView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date 2023/2/23
 * @description
 */

public class DataFragment extends BaseFragment implements ExpressView {

    private RecyclerView rv;
    private MainPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        mPresenter = new MainPresenter(this, this);
        initView(view);
        return view;
    }

    /**
     * 网络请求
     */
    private void request() {
        mPresenter.getList();
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        request();
    }

    @Override
    public void updateView(MainListBean bean) {
        if (bean == null || bean.getMap() == null || bean.getMap().getList() == null)
            return;
        LightAdapter adapter = new LightAdapter(R.layout.item_data, bean.getMap().getList());
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter1, View view, int position) {
                if (view.getId() == R.id.btn) {
                    MainListBean.MapBean.ListBean listBean = adapter.getData().get(position);
                    int dev_id = listBean.getDev_id();
                    startActivity(new Intent(getContext(), ChatActivity.class)
                            .putExtra("id", dev_id));
                }
            }
        });
        rv.setAdapter(adapter);
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
}
