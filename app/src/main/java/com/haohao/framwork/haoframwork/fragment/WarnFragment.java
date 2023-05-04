package com.haohao.framwork.haoframwork.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.activity.EnvironmentActivity;
import com.haohao.framwork.haoframwork.adapter.LightAdapter;
import com.haohao.framwork.haoframwork.framwork.BaseFragment;
import com.haohao.framwork.haoframwork.mvp.bean.MainListBean;
import com.haohao.framwork.haoframwork.mvp.presenter.MainPresenter;
import com.haohao.framwork.haoframwork.mvp.view.ExpressView;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.raphets.roundimageview.RoundImageView;

import java.util.ArrayList;
import java.util.List;


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

public class WarnFragment extends BaseFragment implements ExpressView {

    private RecyclerView rv;
    private MainPresenter mPresenter;
    private RoundImageView iv_main;
    private MZBannerView banner;
    private List<Integer> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warn, container, false);
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
        iv_main = view.findViewById(R.id.iv_main);
        banner = view.findViewById(R.id.banner);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        initBanner();
        request();
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
    public void updateView(MainListBean bean) {
        if (bean == null || bean.getMap() == null || bean.getMap().getList() == null)
            return;
        LightAdapter adapter = new LightAdapter(R.layout.item_share, bean.getMap().getList());
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter1, View view, int position) {
                if (view.getId() == R.id.btn) {
                    MainListBean.MapBean.ListBean listBean = adapter.getData().get(position);
                    int dev_id = listBean.getDev_id();
                    startActivity(new Intent(getContext(), EnvironmentActivity.class)
                            .putExtra("id", dev_id));
                }
            }
        });
        rv.setAdapter(adapter);
    }

    private void initBanner() {
        // 设置数据
        list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        iv_main.setImageResource(R.mipmap.a);
        banner.setPages(list, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        banner.addPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                iv_main.setImageResource(list.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.pause();//暂停轮播
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.start();//开始轮播
    }

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
}
