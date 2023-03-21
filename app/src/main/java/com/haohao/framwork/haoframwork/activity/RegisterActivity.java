package com.haohao.framwork.haoframwork.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText et_account;
    private EditText et_password;
    private EditText et_password_confirm;
    private Button btn_Resgiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password_confirm = (EditText) findViewById(R.id.et_password_confirm);
        btn_Resgiter = (Button) findViewById(R.id.btn_Resgiter);

        btn_Resgiter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Resgiter:

                break;
        }
    }

    private void submit() {
        String account = et_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "account不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String confirm = et_password_confirm.getText().toString().trim();
        if (TextUtils.isEmpty(confirm)) {
            Toast.makeText(this, "confirm不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirm)) {
            Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() != 8) {
            Toast.makeText(this, "请输入8位数字密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 2023/3/21 注册网络请求

    }
}