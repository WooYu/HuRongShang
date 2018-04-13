package com.lcworld.shopdemo.ybg.activity;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.SelectMorePop;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.activity.ChangeChatModeAct;
import com.lcworld.shopdemo.ybg.fragment.SYBGMyFragment;
import com.lcworld.shopdemo.ybg.fragment.SYBGfourFragment;
import com.lcworld.shopdemo.ybg.fragment.SYBGoneFragment;
import com.lcworld.shopdemo.ybg.fragment.SYBGthreeFragment;
import com.lcworld.shopdemo.ybg.fragment.SYBGtwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 移动办公——主页
 */
public class T_YBGMainActivity extends BaseActivity {

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
    private SYBGoneFragment infoFragment;// 1
    private SYBGtwoFragment vFragment;//2
    private SYBGthreeFragment gmFragment;// 3
    private SYBGfourFragment gsFragment;// 4
    private SYBGMyFragment mFragment;// 我的
    private Unbinder unbinder;
    public static Activity mMainActivity = null;
    private int aa = 0;

    @Override
    protected int setContentView() {
        return R.layout.s_act_ybgmain;
    }

    @Override
    protected void initView() {
        aa = getIntent().getExtras().getInt("aa", 0);
        mMainActivity = this;
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }

    @Override
    protected void initData() {
        setFragmentData();
    }

    //初始化 5个主页面
    private void setFragmentData() {
        gmFragment = new SYBGthreeFragment();
        gmFragment.setFlag(aa);
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
                    infoFragment = new SYBGoneFragment();
                }
                newFragment = infoFragment;
                infoFragment.setFlag(aa);
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new SYBGtwoFragment();
                }
                newFragment = vFragment;
                vFragment.setFlag(aa);
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new SYBGthreeFragment();
                }
                newFragment = gmFragment;
                gmFragment.setFlag(aa);
                replaceFragment();
                setChecked(3);
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new SYBGfourFragment();
                }
                newFragment = gsFragment;
                gsFragment.setFlag(aa);
                replaceFragment();
                setChecked(4);
                break;
            case R.id.ll_bottom_05:
                if (mFragment == null) {
                    mFragment = new SYBGMyFragment();
                }
                newFragment = mFragment;
                mFragment.setFlag(aa);
                replaceFragment();
                setChecked(5);
                break;
        }
    }

    private void setChecked(int i) {
        if (aa == 0) {
            ivBottom01.setImageResource(R.mipmap.qx1);
        } else {
            ivBottom01.setImageResource(R.mipmap.qx1aa);
        }
        ivBottom02.setImageResource(R.mipmap.bg1);
        if (aa == 0) {
            ivBottom03.setImageResource(R.mipmap.yw1);
        } else {
            ivBottom03.setImageResource(R.mipmap.hwa);
        }
        ivBottom04.setImageResource(R.mipmap.yb1);
        ivBottom05.setImageResource(R.mipmap.ybgwd1);
        if (aa == 0) {
        } else {
        }
        switch (i) {
            case 1:
                if (aa == 0) {
                    ivBottom01.setImageResource(R.mipmap.qx2);
                } else {
                    ivBottom01.setImageResource(R.mipmap.qx1bb);
                }
                break;
            case 2:
                ivBottom02.setImageResource(R.mipmap.bg2);
                break;
            case 3:
                if (aa == 0) {
                    ivBottom03.setImageResource(R.mipmap.yw2);
                } else {
                    ivBottom03.setImageResource(R.mipmap.hwb);
                }

                break;
            case 4:
                ivBottom04.setImageResource(R.mipmap.yb2);
                break;
            case 5:
                ivBottom05.setImageResource(R.mipmap.ybgwd2);
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

    //右上角三点
    public void doMore(View actionbar) {
        //弹出功能pop
        new SelectMorePop(T_YBGMainActivity.this, new SelectMorePop.SelectCallBack() {
            @Override
            public void onSelected(int more_type) {
                switch (more_type) {
                    case 5:
                        UIManager.turnToAct(T_YBGMainActivity.this, ChangeChatModeAct.class);
                        break;

                    default:
                        break;
                }
            }
        }).showAsDropDown(actionbar, 0, 0);

    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
