package com.lcworld.shopdemo.rmq.activity;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.AppConfig;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.LoginResponse;
import com.lcworld.shopdemo.base.MD5;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.pt.activity.T_PTMainActivity;
import com.lcworld.shopdemo.stq.S_MainActivity;
import com.lcworld.shopdemo.tsq.ui.main.activity.T_MainActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.view_line_code)
    View viewLineCode;
    @BindView(R.id.view_line_pwd)
    View viewLinePwd;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.iv_close_mobile)
    ImageView ivCloseMobile;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.btn_get_code)
    Button btnGetCode;
    @BindView(R.id.ll_login_code)
    LinearLayout llLoginCode;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.look_or_hint)
    ImageView lookOrHint;
    @BindView(R.id.ll_login_pwd)
    LinearLayout llLoginPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.ll_login_pwd_sth)
    LinearLayout llLoginPwdSth;
    private boolean isHintPass = true;
    private boolean isCodeMode = true;

    boolean isShouldFinish;//是否登录成功应该关闭  如果是拓商圈或社团圈应该这么传
    private final static Pattern phoneMatch = Pattern
            .compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");

    @Override
    protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }


    @OnClick({R.id.look_or_hint, R.id.iv_close_mobile, R.id.btn_login})
    public void onClick(View view) {
        String mobile = etMobile.getText().toString().trim();
        switch (view.getId()) {
            case R.id.iv_close_mobile:
                etMobile.setText("");
                etMobile.requestFocus();
                break;
            case R.id.look_or_hint:
                if (isHintPass) {
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isHintPass = false;
                    lookOrHint.setImageResource(R.mipmap.icon_open_pwd);
                } else {
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    lookOrHint.setImageResource(R.mipmap.icon_close_pwd);
                    isHintPass = true;
                }
                etPwd.setSelection(etPwd.getText().toString().length());
                break;
            case R.id.tv_register:
                break;
            case R.id.tv_forget_pwd:
                break;
            case R.id.tv_protocol:
                break;
            case R.id.btn_login:

                if (isVail()) {
                    btnLogin.setEnabled(false);
                    btnLogin.setText("登录中...");
                    //请求接口提交
                    String password = etPwd.getText().toString();
                    doLogin(true, mobile, password, btnLogin);
                }

                break;
        }
    }

    private boolean isVail() {
        String phone = etMobile.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            showToast("手机号不能为空");
            return false;
        }

        if (!phoneMatch.matcher(phone).matches()) {
            showToast("请输入正确的手机号");
            return false;
        }

        String password = etPwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空");
            return false;
        }

        return true;
    }

    //登录操作start

    /**
     * @param isPwd    是否是密码登录
     * @param mobile
     * @param sth      密码或验证码
     * @param btnLogin
     */
    public void doLogin(final boolean isPwd, final String mobile, final String sth, final Button btnLogin) {

        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", mobile);
        if (isPwd)
            params.put("password", MD5.md5(sth));
        else
            params.put("verification", sth);
        final JSONObject jsonObject = new JSONObject(params);
        String timestamp = System.currentTimeMillis() + "";
        String sign = getSign(jsonObject.toString(), timestamp);

        FormBody formBody = new FormBody.Builder()
                .add("biz", jsonObject.toString())
                .add("timestamp", timestamp)
                .build();
        //创建请求
        Request request = new Request.Builder()
                .header("sign", sign)
                .post(formBody)
                .url("http://59.110.161.86:8066/renmaiquan-api/api/login")
                .build();

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("登录异常" );
                e.printStackTrace();
                setLoginBtnStatus();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                setLoginBtnStatus();

                String result = response.body().string();
                System.out.println("数据：" + result);
                LoginResponse loginResponse = new Gson().fromJson(result, LoginResponse.class);
                if (null != loginResponse && null != loginResponse.getUser()) {
                    AppConfig.getInstance().setIsFirst(false);

                    switch (AppConfig.getInstance().getMainType()) {
                        case 0:
                            UIManager.turnToAct(LoginActivity.this, MainActivity.class);
                            break;
                        case 1:
                            UIManager.turnToAct(LoginActivity.this, T_MainActivity.class);
                            break;
                        case 2:
                            UIManager.turnToAct(LoginActivity.this, S_MainActivity.class);
                            break;
                        case 3:
                            UIManager.turnToAct(LoginActivity.this, T_PTMainActivity.class);
                            break;
                        default:
                            break;
                    }
                }

            }

        });

    }

    public String getSign(String s, String timestamp) {
        return MD5.md5(URLEncoder.encode(s) + timestamp + "asdd21314454");
    }

    private  void setLoginBtnStatus(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnLogin.setEnabled(true);
                btnLogin.setText("登录");
            }
        });
    }
}
