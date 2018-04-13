package com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment.TMarketMyFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TQYHomeFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopCartFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopClassificationFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopHomeFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment.TShopInfomationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈——商场——主页
 */
public class T_QYMainActivity extends BaseActivity {

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
    private TShopInfomationFragment infoFragment;// 资讯
    private TShopClassificationFragment vFragment;//分类
    private TQYHomeFragment gmFragment;// 商店主页
    private TShopCartFragment gsFragment;// 购物车
    private TMarketMyFragment mFragment;// 我的
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.t_act_shopmain;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }

    @Override
    protected void initData() {
        setFragmentData();
    }

    //初始化 5个主页面
    private void setFragmentData() {
        gmFragment = new TQYHomeFragment();
        currentFragment = gmFragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_layout, currentFragment).commitAllowingStateLoss();
        setChecked(3);
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

    //切换5个主页面
    @OnClick({R.id.ll_bottom_01, R.id.ll_bottom_02, R.id.ll_bottom_03,
            R.id.ll_bottom_04, R.id.ll_bottom_05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_bottom_01:
                if (infoFragment == null) {
                    infoFragment = new TShopInfomationFragment();
                }
                newFragment = infoFragment;
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new TShopClassificationFragment();
                }
                newFragment = vFragment;
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new TQYHomeFragment();
                }
                newFragment = gmFragment;
                replaceFragment();
                setChecked(3);
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new TShopCartFragment();
                }
                newFragment = gsFragment;
                replaceFragment();
                setChecked(4);
                break;
            case R.id.ll_bottom_05:
                if (mFragment == null) {
                    mFragment = new TMarketMyFragment();
                }
                newFragment = mFragment;
                replaceFragment();
                setChecked(5);
                break;
        }
    }

    private void setChecked(int i) {
        ivBottom01.setImageResource(R.mipmap.zxwxz);
        ivBottom02.setImageResource(R.mipmap.flwxz);
        ivBottom03.setImageResource(R.mipmap.sywxz);
        ivBottom04.setImageResource(R.mipmap.gwcwxz);
        ivBottom05.setImageResource(R.mipmap.wdwxz);

        switch (i) {
            case 1:
                ivBottom01.setImageResource(R.mipmap.zxxz);
                break;
            case 2:
                ivBottom02.setImageResource(R.mipmap.flxz);
                break;
            case 3:
                ivBottom03.setImageResource(R.mipmap.syxz);
                break;
            case 4:
                ivBottom04.setImageResource(R.mipmap.gwcxz);
                break;
            case 5:
                ivBottom05.setImageResource(R.mipmap.wdxz);
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


    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

//
//    //切换版本用   //默认是0人脉聊天  1拓商圈   2社团圈   3移动办公
//    @Subscribe
//    public void onEventMainThread(EventChangeMainTypeFinish event) {
//        finish();
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
