package com.lcworld.shopdemo.stq.headline.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lcworld.shopdemo.MessageEvent;
import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.sh.activity.T_SHMainActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.T_ShopMainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SheTuanQuanMainActivity  extends BaseActivity {


    @BindView(R.id.view_back)
    View viewBack;
    @BindView(R.id.rb_left)
    RadioButton rbLeft;
    @BindView(R.id.rb_right)
    RadioButton rbRight;
    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.iv_renwufengcai)
    ImageView ivLeft;
    @BindView(R.id.iv_shetuanliebiao)
    ImageView ivRight;

    @Override
    protected int setContentView() {
        return R.layout.activity_she_tuan_quan_main;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
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

    @OnClick({R.id.view_back, R.id.rb_left,R.id.rb_right, R.id.rg_tab,
            R.id.iv_renwufengcai, R.id.iv_shetuanliebiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_back:
                finish();
                break;
            case R.id.rb_left:
                ivLeft.setVisibility(View.VISIBLE);
                ivRight.setVisibility(View.GONE);
                break;
            case R.id.rb_right:
                ivRight.setVisibility(View.VISIBLE);
                ivLeft.setVisibility(View.GONE);
                break;
            case R.id.rg_tab:
                break;
            case R.id.iv_renwufengcai:
                UIManager.turnToAct(this, NewsDetailsActivity.class);
                break;
            case R.id.iv_shetuanliebiao:
                UIManager.turnToAct(this, T_SHMainActivity.class);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        finish();
    }
}

