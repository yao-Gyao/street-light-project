package com.haohao.framwork.haoframwork.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.application.BaseApplication;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.utils.HttpInterceptorUtil;

import java.util.ArrayList;

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
 * @date ${DATE}
 * @description 登录页
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    /**
     * 从token失效弹窗进来
     */
    private boolean isFromDialog;
    private EditText et_account;
    private EditText et_password;
    private Button btn_Login;
    private Button btn_Resgiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isFromDialog = getIntent().getBooleanExtra("dialog", false);
        initView();
    }

    private void initView() {
        et_account = (EditText) findViewById(R.id.et_account);
        et_account.setOnClickListener(this);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password.setOnClickListener(this);
        btn_Login = (Button) findViewById(R.id.btn_Login);
        btn_Login.setOnClickListener(this);
        btn_Resgiter = (Button) findViewById(R.id.btn_Resgiter);
        btn_Resgiter.setOnClickListener(this);
    }

    /**
     * token失效,重新登录成功
     */
    private void fromTokenDialogLoginSuccess() {
        HttpInterceptorUtil.getInstance().dismissTokenDialog();
        BaseApplication application = BaseApplication.getInstance();
        ArrayList<Activity> activityStack = application.getActivityStack();
        if (activityStack != null && activityStack.size() > 1) {
            BaseActivity activity = (BaseActivity) activityStack.get(activityStack.size() - 2);
            activity.initRequest();
        }
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Login:
                submit();
                break;
            case R.id.btn_Resgiter:
                startActivity(new Intent(this,RegisterActivity.class));
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

        if (password.length() != 8) {
            Toast.makeText(this, "请输入8位数字密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 2023/3/21 登录网络请求
        startActivity(new Intent(this,MainActivity.class));

    }
}