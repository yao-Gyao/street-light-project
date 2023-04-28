package com.haohao.framwork.haoframwork.activity;

import android.os.Bundle;
import android.view.View;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;

public class LinkMeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_me);
        setStatusBar(true);
        findViewById(R.id.tilt_left_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}