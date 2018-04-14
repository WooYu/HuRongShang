package com.lcworld.shopdemo.rmq.activity;

import android.os.Bundle;
import android.view.View;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//个人信息
public class PersonInfoActivity extends BaseActivity {


    @BindView(R.id.view_back)
    View viewBack;

    @Override
    protected int setContentView() {
        return R.layout.activity_person_info;
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

    @OnClick(R.id.view_back)
    public void onViewClicked() {
        finish();
    }
}
