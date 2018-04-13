package com.lcworld.shopdemo.pt.activity;


import android.app.Activity;
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
import com.lcworld.shopdemo.base.SelectMorePop;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.pt.fragment.PTCommunityFragment;
import com.lcworld.shopdemo.pt.fragment.PTGSCFragment;
import com.lcworld.shopdemo.pt.fragment.PTZPFragment;
import com.lcworld.shopdemo.pt.fragment.PTZSFragment;
import com.lcworld.shopdemo.rmq.activity.ChangeChatModeAct;
import com.lcworld.shopdemo.rmq.fragment.MyFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 移动办公——主页
 */
public class T_PTMainActivity extends BaseActivity {

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
    private PTCommunityFragment infoFragment;// 1
    private PTZSFragment vFragment;//2
    private PTGSCFragment gmFragment;// 3
    private PTZPFragment gsFragment;// 4
    private MyFragment mFragment;// 我的
    private Unbinder unbinder;
    public static Activity mMainActivity = null;

    @Override
    protected int setContentView() {
        return R.layout.s_act_ptmain;
    }

    @Override
    protected void initView() {
        mMainActivity = this;
        EventBus.getDefault().register(this);
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }

    @Override
    protected void initData() {
        setFragmentData();
    }

    //初始化 5个主页面
    private void setFragmentData() {
        gmFragment = new PTGSCFragment();
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
                    infoFragment = new PTCommunityFragment();
                }
                newFragment = infoFragment;
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new PTZSFragment();
                }
                newFragment = vFragment;
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new PTGSCFragment();
                }
                newFragment = gmFragment;
                replaceFragment();
                setChecked(3);
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new PTZPFragment();
                }
                newFragment = gsFragment;
                replaceFragment();
                setChecked(4);
                break;
            case R.id.ll_bottom_05:
                if (mFragment == null) {
                    mFragment = new MyFragment();
                }
                newFragment = mFragment;
                replaceFragment();
                setChecked(5);
                break;
        }
    }

    private void setChecked(int i) {
        ivBottom01.setImageResource(R.mipmap.ptsp1);
        ivBottom02.setImageResource(R.mipmap.ptzs1);
        ivBottom03.setImageResource(R.mipmap.ptb1);
        ivBottom04.setImageResource(R.mipmap.ptzp1);
        ivBottom05.setImageResource(R.mipmap.ptwd1);

        switch (i) {
            case 1:
                ivBottom01.setImageResource(R.mipmap.ptsp2);
                break;
            case 2:
                ivBottom02.setImageResource(R.mipmap.ptzs2);
                break;
            case 3:
                ivBottom03.setImageResource(R.mipmap.ptb2);
                break;
            case 4:
                ivBottom04.setImageResource(R.mipmap.ptzp2);
                break;
            case 5:
                ivBottom05.setImageResource(R.mipmap.ptwd2);
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
        new SelectMorePop(T_PTMainActivity.this, new SelectMorePop.SelectCallBack() {
            @Override
            public void onSelected(int more_type) {
                switch (more_type) {
                    case 5:
                        UIManager.turnToAct(T_PTMainActivity.this, ChangeChatModeAct.class);
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
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        finish();
    }
}
