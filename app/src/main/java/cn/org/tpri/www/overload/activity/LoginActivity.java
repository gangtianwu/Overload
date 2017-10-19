package cn.org.tpri.www.overload.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import cn.org.tpri.www.overload.R;
import cn.org.tpri.www.overload.bean.LoginBean;
import cn.org.tpri.www.overload.utils.Constant;
import cn.org.tpri.www.overload.utils.JsonUtil;
import cn.org.tpri.www.overload.utils.SharedPreferencesTool;
import okhttp3.Call;

/**
 * 作者:丁文 on 2017/3/17.
 * copyright: www.tpri.org.cn
 */

public class LoginActivity extends AppCompatActivity {

    private EditText login_user_id;
    private EditText login_user_password;
    private Button btn_login;
    private String mUserId;
    private String mUserPassword;
    private ProgressBar pb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SharedPreferencesTool.getBoolean(this, "isLogin", false) && !TextUtils.isEmpty(SharedPreferencesTool.getString(this, "token", ""))) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        initView();
        initData();

    }

    private void initData() {

//        LogUtils.i("账号和密码",mUserId + mUserPassword);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUserId = login_user_id.getText().toString().trim();
                mUserPassword = login_user_password.getText().toString().trim();
                if (mUserId == null || mUserId.length() == 0) {
                    Toast.makeText(LoginActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mUserPassword == null || mUserPassword.length() == 0) {
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
//                loginAction();
                login_server();
            }
        });

    }
    //登录选择服务器操作
    private void login_server(){
        pb.setVisibility(View.VISIBLE); //登录提示进度

        /**
         * 2017年9月14日  临时修改为天津账号登录操作,不进行内部服务器选择的操作↓
         */
        SharedPreferencesTool.saveString(LoginActivity.this, "SERVER_PATH", Constant.SERVER_PATH_TIANJIN);
        loginAction();
        //登录部级服务器判断使用 用户的区域,然后根据用户区域选择服务器

        /*
        OkHttpUtils.get()
                .url(Constant.SERVER_PATH_MINISTRY + Constant.LOGIN_ACTION)
                .addParams("userId", mUserId)
                .addParams("password", mUserPassword)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                pb.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "网络或服务器原因,数据获取失败,请检查网络设置", Toast.LENGTH_SHORT).show();
                LogUtils.i("错误信息", e.toString());
            }

            @Override
            public void onResponse(String response, int id) {

                LoginBean bean = JsonUtil.parseObject(response, LoginBean.class);
                if (bean.getCode().equals("0000")) {
                    if (bean.getData() != null) {
                        //判断服务器地址
                        if (bean.getData().getDist_code() != null && bean.getData().getDist_code().length() > 2) {
                            String DIST_CODE = bean.getData().getDist_code().substring(0, 2);

                            if (DIST_CODE.equals("00")) {
                                SharedPreferencesTool.saveString(LoginActivity.this, "SERVER_PATH", Constant.SERVER_PATH_MINISTRY);
                                loginAction();
                                return;
                            }
                            if (DIST_CODE.equals("11")) {
                                SharedPreferencesTool.saveString(LoginActivity.this, "SERVER_PATH", Constant.SERVER_PATH_BEIJING);
                                loginAction();
                                return;
                            }
                            if (DIST_CODE.equals("12")){
                                SharedPreferencesTool.saveString(LoginActivity.this, "SERVER_PATH", Constant.SERVER_PATH_TIANJIN);
                                loginAction();
                                return;
                            }

                        }
                    } else {
                        pb.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "登录失败:" + bean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                pb.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "登录失败:" + bean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        */
    }

    private void loginAction() {
        OkHttpUtils.get()
                .url(SharedPreferencesTool.getString(this,"SERVER_PATH","") + Constant.LOGIN_ACTION)
                .addParams("userId", mUserId)
                .addParams("password", mUserPassword)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                pb.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "网络或服务器原因,数据获取失败,请检查网络设置", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response, int id) {
                LoginBean bean = JsonUtil.parseObject(response, LoginBean.class);
                if (bean.getCode().equals("0000")) {
                    if (bean.getData() != null) {
                        pb.setVisibility(View.GONE);
                        SharedPreferencesTool.saveBoolean(LoginActivity.this, "isLogin", true);
                        SharedPreferencesTool.saveString(LoginActivity.this, "token", response);
                        SharedPreferencesTool.saveString(LoginActivity.this, "user_login_info", response);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        return;
                    } else {
                        pb.setVisibility(View.GONE);
                    }
                }
                pb.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "登录失败:" + bean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        login_user_id = (EditText) findViewById(R.id.login_user_account);
        login_user_password = (EditText) findViewById(R.id.login_user_passwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        pb = (ProgressBar) findViewById(R.id.login_pb);
    }
}
