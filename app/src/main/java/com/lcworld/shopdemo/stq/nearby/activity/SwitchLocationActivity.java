package com.lcworld.shopdemo.stq.nearby.activity;


import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.NoSlidingListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 社团圈-切换位置
 */
public class SwitchLocationActivity extends BaseActivity {

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.ll_search_click)
    LinearLayout llSearchClick;
    @BindView(R.id.ll_location)
    LinearLayout llLocation;
    @BindView(R.id.lv_address)
    NoSlidingListView lvAddress;

    private Unbinder unbinder;

    //    AddressSearchActivity
    @Override
    protected int setContentView() {
        return R.layout.s_act_swith_loction;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }


    @Override
    protected void initData() {
    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.ll_back, R.id.ll_location})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_location:
                break;
        }
    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
