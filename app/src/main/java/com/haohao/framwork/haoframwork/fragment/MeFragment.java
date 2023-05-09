package com.haohao.framwork.haoframwork.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.activity.LinkMeActivity;
import com.haohao.framwork.haoframwork.activity.LoginActivity;
import com.haohao.framwork.haoframwork.application.BaseApplication;
import com.haohao.framwork.haoframwork.framwork.BaseFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


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

public class MeFragment extends BaseFragment {

    private TextView tv_me_name;
    private FrameLayout fl_link;
    private FrameLayout fl_update_pwd;
    private Button btn_out;
    private MZBannerView banner;
    private List<Integer> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        return view;
    }


    private void initView(View view) {
        tv_me_name = view.findViewById(R.id.tv_me_name);
        fl_link = view.findViewById(R.id.fl_link);
        fl_update_pwd = view.findViewById(R.id.fl_update_pwd);
        btn_out = view.findViewById(R.id.btn_out);

        tv_me_name.setText(BaseApplication.mUser.getUser_name());
        banner = view.findViewById(R.id.banner);
        initBanner();

        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().finish();
            }
        });

        fl_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LinkMeActivity.class));
            }
        });
    }

    private void initBanner() {
        // 设置数据
        list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        banner.setPages(list, new MZHolderCreator<WarnFragment.BannerViewHolder>() {
            @Override
            public WarnFragment.BannerViewHolder createViewHolder() {
                return new WarnFragment.BannerViewHolder();
            }
        });
    }
}
