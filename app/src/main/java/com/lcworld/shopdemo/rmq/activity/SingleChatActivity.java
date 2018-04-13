package com.lcworld.shopdemo.rmq.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.telecom.Call;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.Actionbar;
import com.lcworld.shopdemo.base.AppConfig;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.CommonUtil;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.base.application.CCApplication;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission_group.LOCATION;
import static com.lcworld.shopdemo.R.id.actionbar;
import static com.lcworld.shopdemo.R.id.tv_yjhj_count;

/**
 * 创建：duke
 * 日期： 2017/4/24
 * 注释：私聊聊天页面
 * 版本： 1.0.0
 */
public class SingleChatActivity extends BaseActivity {


    @Override
    protected int setContentView() {
        return R.layout.activity_chat_single;
    }

    @Override
    protected void initView() {
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
        ButterKnife.bind(this);

    }


    @Override
    protected void initData() {
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void setListener() {
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return true;
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }


}
