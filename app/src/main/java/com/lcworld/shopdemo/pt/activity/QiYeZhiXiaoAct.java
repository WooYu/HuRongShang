package com.lcworld.shopdemo.pt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
//企业圈-商城-直销
public class QiYeZhiXiaoAct extends BaseActivity {

    @Override
    protected int setContentView() {
        return R.layout.activity_qi_ye_zhi_xiao;
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

    @OnClick({R.id.ll_back, R.id.iv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_left:
                finish();
                break;
        }
    }
}
