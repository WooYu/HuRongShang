package com.lcworld.shopdemo.sh.activity;


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
import com.lcworld.shopdemo.sh.fragment.SSHHomeFragment;
import com.lcworld.shopdemo.sh.fragment.SSHInfomationFragment;
import com.lcworld.shopdemo.sh.fragment.SSHMarketFragment;
import com.lcworld.shopdemo.sh.fragment.SSHMyFragment;
import com.lcworld.shopdemo.sh.fragment.SSHVideoFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 社团圈-商会——主页
 */
public class T_SHMainActivity extends BaseActivity {

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
    private SSHInfomationFragment infoFragment;// 资讯
    private SSHVideoFragment vFragment;//商会视频
    private SSHHomeFragment gmFragment;// 商场
    private SSHMarketFragment gsFragment;// 优惠
    private SSHMyFragment mFragment;// 我的
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.s_act_shmain;
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

    //初始化 5个主页面
    private void setFragmentData() {
        gmFragment = new SSHHomeFragment();
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
                    infoFragment = new SSHInfomationFragment();
                }
                newFragment = infoFragment;
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new SSHVideoFragment();
                }
                newFragment = vFragment;
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new SSHHomeFragment();
                }
                newFragment = gmFragment;
                replaceFragment();
                setChecked(3);
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new SSHMarketFragment();
                }
                newFragment = gsFragment;
                replaceFragment();
                setChecked(4);
                break;
            case R.id.ll_bottom_05:
                if (mFragment == null) {
                    mFragment = new SSHMyFragment();
                }
                newFragment = mFragment;
                replaceFragment();
                setChecked(5);
                break;
        }
    }

    private void setChecked(int i) {
        ivBottom01.setImageResource(R.mipmap.shzx1);
        ivBottom02.setImageResource(R.mipmap.shsp1);
        ivBottom03.setImageResource(R.mipmap.shsy1);
        ivBottom04.setImageResource(R.mipmap.shsc1);
        ivBottom05.setImageResource(R.mipmap.shwd1);

        switch (i) {
            case 1:
                ivBottom01.setImageResource(R.mipmap.shzx2);
                break;
            case 2:
                ivBottom02.setImageResource(R.mipmap.shsp2);
                break;
            case 3:
                ivBottom03.setImageResource(R.mipmap.shsy2);
                break;
            case 4:
                ivBottom04.setImageResource(R.mipmap.shsc2);
                break;
            case 5:
                ivBottom05.setImageResource(R.mipmap.shwd2);
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        finish();
    }
}
