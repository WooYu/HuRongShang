package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment;

import android.content.Context;
import android.view.View;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.activity.T_MarketMainActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.T_ShopMainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈-商铺-优惠
 */
public class TMallDiscountFragment extends BaseFragment {

    Unbinder unbinder;
    private T_MarketMainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (T_MarketMainActivity) context;
    }

    @Override
    protected int setContentView() {
        return R.layout.t_frag_markmain_yh;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
    }


    @Override
    protected void initData() {


    }


    @Override
    protected void setListener() {

    }

    @OnClick({R.id.iv1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv1:
                UIManager.turnToAct(getActivity(), T_ShopMainActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
