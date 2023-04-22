package com.haohao.framwork.haoframwork.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.application.BaseApplication;
import com.haohao.framwork.haoframwork.fragment.MeFragment;
import com.haohao.framwork.haoframwork.fragment.StatusFragment;
import com.haohao.framwork.haoframwork.fragment.UpdateFragment;
import com.haohao.framwork.haoframwork.fragment.WarnFragment;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.framwork.TabViewPagerAdapter;
import com.vondear.rxtool.RxPermissionsTool;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

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
 * @date
 * @description
 */

public class MainActivity extends BaseActivity {

    private ViewPager vp_main;
    private TabLayout tab_main;
    private List<Fragment> mFragments;
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPermission();
    }

    private void initPermission() {
        RxPermissionsTool.with(this)
                .addPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .addPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .addPermission(Manifest.permission.CAMERA)
                .addPermission(Manifest.permission.READ_PHONE_STATE)
                .addPermission(Manifest.permission.ACCESS_WIFI_STATE)
                .addPermission(Manifest.permission.CHANGE_WIFI_STATE)
                .addPermission(Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS)
                .addPermission(Manifest.permission.READ_CONTACTS)
                .addPermission(Manifest.permission.WRITE_CONTACTS)
                .addPermission(Manifest.permission.RECORD_AUDIO)
                .addPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .addPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .initPermission();
    }

    private void initView() {
        setStatusBarFixWindow(true);
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        initTabLayout();
    }

    private void initTabLayout() {
        mFragments = new ArrayList<>();
        mFragments.add(new StatusFragment());
        mFragments.add(new WarnFragment());
        mFragments.add(new UpdateFragment());
        mFragments.add(new MeFragment());
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager(), mFragments);
        vp_main.setAdapter(adapter);
        tab_main.setupWithViewPager(vp_main);
        tab_main.getTabAt(0).setCustomView(setTabView(getResources().getString(R.string.tab_one),R.drawable.tab_one));
        tab_main.getTabAt(1).setCustomView(setTabView(getResources().getString(R.string.tab_two),R.drawable.tab_two));
        tab_main.getTabAt(2).setCustomView(setTabView(getResources().getString(R.string.tab_three),R.drawable.tab_three));
        tab_main.getTabAt(3).setCustomView(setTabView(getResources().getString(R.string.tab_four),R.drawable.tab_five));

        tab_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //设置选中时的文字颜色
                if (tab.getCustomView() != null) {
                    TextView tabTitle = tab.getCustomView().findViewById(R.id.tv_tab);
                    tabTitle.setTextColor(getResources().getColor(R.color.tab_select));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //设置未选中时的文字颜色
                if (tab.getCustomView() != null) {
                    TextView tabTitle = tab.getCustomView().findViewById(R.id.tv_tab);
                    tabTitle.setTextColor(getResources().getColor(R.color.tab_unselect));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private View setTabView(String title,Integer res){
        View view = LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
        ImageView iv_tab = view.findViewById(R.id.iv_tab);
        TextView tv_tab = view.findViewById(R.id.tv_tab);
        iv_tab.setImageResource(res);
        tv_tab.setText(title);
        return view;
    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                BaseApplication.getInstance().AppExit();
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
