package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment.TMallClassificationFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment.TMallDiscountFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment.TMallInfomationFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment.TMallMarketsFragment;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment.TMarketMyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈——商场——主页
 */
public class T_MarketMainActivity extends BaseActivity {

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
    private TMallInfomationFragment infoFragment;// 资讯
    private TMallClassificationFragment vFragment;//分类
    private TMallMarketsFragment gmFragment;// 商场
    private TMallDiscountFragment gsFragment;// 优惠
    private TMarketMyFragment mFragment;// 我的
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.t_act_mallmain;
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
        gmFragment = new TMallMarketsFragment();
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
                    infoFragment = new TMallInfomationFragment();
                }
                newFragment = infoFragment;
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (vFragment == null) {
                    vFragment = new TMallClassificationFragment();
                }
                newFragment = vFragment;
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (gmFragment == null) {
                    gmFragment = new TMallMarketsFragment();
                }
                newFragment = gmFragment;
                replaceFragment();
                setChecked(3);
                break;
            case R.id.ll_bottom_04:

                if (gsFragment == null) {
                    gsFragment = new TMallDiscountFragment();
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
        tvBottom01.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom01.setImageResource(R.mipmap.t_mallinfo_unchecked);
        tvBottom02.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom02.setImageResource(R.mipmap.t_mallclassification_unchecked);
        tvBottom03.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom03.setImageResource(R.mipmap.t_mallmarket_unchecked);
        ivBottom04.setImageResource(R.mipmap.t_malldiscount_unchecked);
        tvBottom05.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom05.setImageResource(R.mipmap.t_mallmy_unchecked);

        switch (i) {
            case 1:
                tvBottom01.setTextColor(getResources().getColor(R.color.theme_tsq_market));
                ivBottom01.setImageResource(R.mipmap.t_mallinfo_checked);
                break;
            case 2:
                tvBottom02.setTextColor(getResources().getColor(R.color.theme_tsq_market));
                ivBottom02.setImageResource(R.mipmap.t_mallclassification_checked);
                break;
            case 3:
                tvBottom03.setTextColor(getResources().getColor(R.color.theme_tsq_market));
                ivBottom03.setImageResource(R.mipmap.t_mallmarket_checked);
                break;
            case 4:
                ivBottom04.setImageResource(R.mipmap.t_malldiscount_checked);
                break;
            case 5:
                tvBottom05.setTextColor(getResources().getColor(R.color.theme_tsq_market));
                ivBottom05.setImageResource(R.mipmap.t_mallmy_checked);
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
        unbinder.unbind();
    }

}
