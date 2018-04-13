package com.lcworld.shopdemo.tsq.ui.main.activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcworld.shopdemo.MessageEvent;
import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.CommonUtil;
import com.lcworld.shopdemo.base.SelectMorePop;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.activity.ChangeChatModeAct;
import com.lcworld.shopdemo.rmq.fragment.MyFragment;
import com.lcworld.shopdemo.tsq.ui.main.fragment.TCommunityFragment;
import com.lcworld.shopdemo.tsq.ui.main.fragment.TGoMallsFragment;
import com.lcworld.shopdemo.tsq.ui.main.fragment.TGoShoppingFragment;
import com.lcworld.shopdemo.tsq.ui.main.fragment.TVideoListFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈主页
 */
public class T_MainActivity extends BaseActivity {

    @BindView(R.id.ll_search_input)
    LinearLayout llSearchInput;
    @BindView(R.id.ll_input_click)
    LinearLayout llInputClick;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.content_layout)
    FrameLayout contentLayout;
    @BindView(R.id.iv_bottom_01)
    ImageView ivBottom01;
    @BindView(R.id.tv_bottom_01)
    TextView tvBottom01;
    @BindView(R.id.ll_bottom_01)
    LinearLayout llBottom01;
    @BindView(R.id.iv_bottom_02)
    ImageView ivBottom02;
    @BindView(R.id.tv_bottom_02)
    TextView tvBottom02;
    @BindView(R.id.ll_bottom_02)
    LinearLayout llBottom02;
    @BindView(R.id.iv_bottom_03)
    ImageView ivBottom03;
    @BindView(R.id.tv_bottom_03)
    TextView tvBottom03;
    @BindView(R.id.ll_bottom_03)
    LinearLayout llBottom03;
    @BindView(R.id.iv_bottom_04)
    ImageView ivBottom04;
    @BindView(R.id.tv_bottom_04)
    TextView tvBottom04;
    @BindView(R.id.ll_bottom_04)
    LinearLayout llBottom04;
    @BindView(R.id.iv_bottom_05)
    ImageView ivBottom05;
    @BindView(R.id.tv_bottom_05)
    TextView tvBottom05;
    @BindView(R.id.ll_bottom_05)
    LinearLayout llBottom05;
    @BindView(R.id.ll_all_bottom)
    LinearLayout llAllBottom;

    private Fragment newFragment;// 切换的页面
    private Fragment currentFragment;// 当前的页面
    private TCommunityFragment cFragment;// 社区
    private TVideoListFragment vFragment;// 视频
    private TGoMallsFragment gmFragment;// 逛商场
    private TGoShoppingFragment gsFragment;// 逛街
    private MyFragment mFragment;// 我的
    private Unbinder unbinder;
    public static Activity mMainActivity = null;

    @Override
    protected int setContentView() {
        return R.layout.t_act_main;
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
//        checkVersion();
    }

    //初始化 5个主页面
    private void setFragmentData() {
        gmFragment = new TGoMallsFragment();
        currentFragment = gmFragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_layout, currentFragment).commitAllowingStateLoss();
        setChecked(3);
    }


    @Override
    protected void setListener() {
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == 0 || actionId == 3) && event != null) {
                    search();
                }
                return false;
            }
        });
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
            R.id.ll_bottom_04, R.id.ll_bottom_05, R.id.tv_cancel, R.id.ll_input_click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                showSearch();
                break;
            case R.id.ll_input_click:
                search();
                break;
            case R.id.ll_bottom_01:
                if (cFragment == null) {
                    cFragment = new TCommunityFragment();
                }
                newFragment = cFragment;
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new TVideoListFragment();
                }
                newFragment = vFragment;
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new TGoMallsFragment();
                }
                newFragment = gmFragment;
                replaceFragment();
                setChecked(3);
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new TGoShoppingFragment();
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
        tvBottom01.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom01.setImageResource(R.mipmap.t_sq_normal);
        tvBottom02.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom02.setImageResource(R.mipmap.t_sp_normal);
        tvBottom03.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom03.setImageResource(R.mipmap.t_gsc_normal);
        tvBottom04.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom04.setImageResource(R.mipmap.t_gj_normal);
        tvBottom05.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom05.setImageResource(R.mipmap.t_wd_normal);

        switch (i) {
            case 1:
                tvBottom01.setTextColor(getResources().getColor(R.color.theme_tsq));
                ivBottom01.setImageResource(R.mipmap.t_sq_checked);
                break;
            case 2:
                tvBottom02.setTextColor(getResources().getColor(R.color.theme_tsq));
                ivBottom02.setImageResource(R.mipmap.t_sp_checked);
                break;
            case 3:
                tvBottom03.setTextColor(getResources().getColor(R.color.theme_tsq));
                ivBottom03.setImageResource(R.mipmap.t_gsc_checked);
                break;
            case 4:
                tvBottom04.setTextColor(getResources().getColor(R.color.theme_tsq));
                ivBottom04.setImageResource(R.mipmap.t_gj_checked);
                break;
            case 5:
                tvBottom05.setTextColor(getResources().getColor(R.color.theme_tsq));
                ivBottom05.setImageResource(R.mipmap.t_wd_checked);
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
     * 显示/隐藏搜索
     */
    public void showSearch() {
        if (llSearchInput.getVisibility() == View.GONE) {
            llSearchInput.setVisibility(View.VISIBLE);
            CommonUtil.openSoftKeyboard(this);
        } else {
            llSearchInput.setVisibility(View.GONE);
            CommonUtil.hideSoftKeyboard(this);
        }
    }

    /**
     * 搜索
     */
    public void search() {
        String text = etSearch.getText().toString();
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(text)) {
            bundle.putString("content", text);
        }
//        if (currentFragment instanceof VideoFragment) {
//            UIManager.turnToAct(this, VideoSearchActivity.class, bundle);
//        } else if (currentFragment instanceof NearbyFragment) {
//            UIManager.turnToAct(this, NearbySearchActivity.class, bundle);
//        } else {
//            UIManager.turnToAct(this, NewsSearchActivity.class, bundle);
//        }
        if (llSearchInput.getVisibility() != View.GONE) {
            llSearchInput.setVisibility(View.GONE);
            CommonUtil.hideSoftKeyboard(this);
        }
    }

    //    //切换版本用   //默认是0人脉聊天  1拓商圈   2社团圈   3移动办公
//    @Subscribe
//    public void onEventMainThread(EventChangeMainTypeFinish event) {
//        finish();
//    }
//右上角三点
    public void doMore(View actionbar) {
        //弹出功能pop
        new SelectMorePop(T_MainActivity.this, new SelectMorePop.SelectCallBack() {
            @Override
            public void onSelected(int more_type) {
                switch (more_type) {
                    case 5:
                        UIManager.turnToAct(T_MainActivity.this, ChangeChatModeAct.class);
                        break;

                    default:
                        break;
                }
            }
        }).showAsDropDown(actionbar, 0, 0);

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
