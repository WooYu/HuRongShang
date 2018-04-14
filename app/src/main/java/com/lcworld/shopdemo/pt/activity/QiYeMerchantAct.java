package com.lcworld.shopdemo.pt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lcworld.shopdemo.MessageEvent;
import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.pt.fragment.QYGouWuFrag;
import com.lcworld.shopdemo.pt.fragment.QYShangChengFrag;
import com.lcworld.shopdemo.pt.fragment.QYShangMineFrag;
import com.lcworld.shopdemo.pt.fragment.QYShangZhuYeFrag;
import com.lcworld.shopdemo.pt.fragment.QYZhiXuFrag;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopCartFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopClassificationFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopHomeFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopInfomationFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopMyFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//企业圈-商城
public class QiYeMerchantAct extends BaseActivity {

    @BindView(R.id.content_layout)
    FrameLayout contentLayout;
    @BindView(R.id.iv_bottom_01)
    ImageView ivBottom01;
    @BindView(R.id.ll_bottom_01)
    LinearLayout llBottom01;
    @BindView(R.id.iv_bottom_02)
    ImageView ivBottom02;
    @BindView(R.id.ll_bottom_02)
    LinearLayout llBottom02;
    @BindView(R.id.iv_bottom_03)
    ImageView ivBottom03;
    @BindView(R.id.ll_bottom_03)
    LinearLayout llBottom03;
    @BindView(R.id.iv_bottom_04)
    ImageView ivBottom04;
    @BindView(R.id.ll_bottom_04)
    LinearLayout llBottom04;
    @BindView(R.id.iv_bottom_05)
    ImageView ivBottom05;
    @BindView(R.id.ll_bottom_05)
    LinearLayout llBottom05;
    @BindView(R.id.ll_all_bottom)
    LinearLayout llAllBottom;

    private Fragment newFragment;// 切换的页面
    private Fragment currentFragment;// 当前的页面
    private QYZhiXuFrag infoFragment;// 资讯
    private QYShangChengFrag vFragment;//商场
    private QYShangZhuYeFrag gmFragment;// 主页
    private QYGouWuFrag gsFragment;// 购物车
    private QYShangMineFrag mFragment;// 我的
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.activity_qi_ye_merchant;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initData() {
        setFragmentData();
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

    //初始化 5个主页面
    private void setFragmentData() {
        gmFragment = new QYShangZhuYeFrag();
        currentFragment = gmFragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_layout, currentFragment).commitAllowingStateLoss();
        setChecked(R.id.ll_bottom_03);
    }
    //切换5个主页面
    @OnClick({R.id.ll_bottom_01, R.id.ll_bottom_02, R.id.ll_bottom_03,
            R.id.ll_bottom_04, R.id.ll_bottom_05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_bottom_01:
                if (infoFragment == null) {
                    infoFragment = new QYZhiXuFrag();
                }
                newFragment = infoFragment;
                replaceFragment();
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new QYShangChengFrag();
                }
                newFragment = vFragment;
                replaceFragment();
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new QYShangZhuYeFrag();
                }
                newFragment = gmFragment;
                replaceFragment();
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new QYGouWuFrag();
                }
                newFragment = gsFragment;
                replaceFragment();
                break;
            case R.id.ll_bottom_05:
                if (mFragment == null) {
                    mFragment = new QYShangMineFrag();
                }
                newFragment = mFragment;
                replaceFragment();
                break;
        }
        setChecked(view.getId());
    }

    private void setChecked(int i) {
        ivBottom01.setImageResource(R.mipmap.qyzx1);
        ivBottom02.setImageResource(R.mipmap.qysc1);
        ivBottom03.setImageResource(R.mipmap.qyzy1);
        ivBottom04.setImageResource(R.mipmap.qigw_1);
        ivBottom05.setImageResource(R.mipmap.qywd1);

        switch (i) {
            case R.id.ll_bottom_01:
                ivBottom01.setImageResource(R.mipmap.qyzy2);
                break;
            case R.id.ll_bottom_02:
                ivBottom02.setImageResource(R.mipmap.qysc2);
                break;
            case R.id.ll_bottom_03:
                ivBottom03.setImageResource(R.mipmap.qyzy2);
                break;
            case R.id.ll_bottom_04:
                ivBottom04.setImageResource(R.mipmap.qygw_2);
                break;
            case R.id.ll_bottom_05:
                ivBottom05.setImageResource(R.mipmap.qywd2);
                break;
        }
    }

    private void replaceFragment() {
        if (newFragment != currentFragment) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (newFragment.isAdded()) {
                transaction.show(newFragment);
            } else {
                transaction.add(R.id.content_layout, newFragment);
            }
            transaction.hide(currentFragment).commitAllowingStateLoss();
            currentFragment = newFragment;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        finish();
    }

}
