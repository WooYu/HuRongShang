package com.lcworld.shopdemo.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.pt.activity.T_PTMainActivity;
import com.lcworld.shopdemo.rmq.activity.MainActivity;
import com.lcworld.shopdemo.stq.S_MainActivity;
import com.lcworld.shopdemo.tsq.ui.main.activity.T_MainActivity;


/**
 * 创建：dongshuaijun
 * 日期： 2016/8/3
 * 注释：启动页面
 */
public class SplashActivity extends AppCompatActivity {
    private static final long DELAY_TIME = 1000L;
    private final int COMPLETE = 1;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case COMPLETE:
//                    if (AppConfig.getInstance().getIsFirst()) {
//                        //第一次打开应用 启动引导页面
//                        AppConfig.getInstance().setIsFirst(false);
//                        ActivitySkipUtil.skip(SplashActivity.this, GuideActivity.class);
//                    } else {
                    //先判断上次退出是哪个端退出的
                    switch (AppConfig.getInstance().getMainType()) {
                        case 0:
                            UIManager.turnToAct(SplashActivity.this, MainActivity.class);
                            break;
                        case 1:
                            UIManager.turnToAct(SplashActivity.this, T_MainActivity.class);
                            break;
                        case 2:
                            UIManager.turnToAct(SplashActivity.this, S_MainActivity.class);
                            break;
                        case 3:
                            UIManager.turnToAct(SplashActivity.this, T_PTMainActivity.class);
                            break;
                        default:
                            break;
                    }
//                    }
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        initView();

        mHandler.sendEmptyMessage(COMPLETE);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            System.exit(0);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
