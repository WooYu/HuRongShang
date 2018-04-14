package com.lcworld.shopdemo.pt.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.pt.activity.QiYeZhiXiaoAct;
import com.lcworld.shopdemo.stq.headline.activity.NewsSearchActivity;
import com.lcworld.shopdemo.stq.nearby.activity.NearbySearchActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.GoodsDetailActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.TGoodsCardCategoryActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.T_QYMainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QYShangChengFrag extends BaseFragment {

    Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.frag_qy_shop;
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


    @OnClick({R.id.ll_back, R.id.ll_search,R.id.iv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                getActivity().finish();
                break;
            case R.id.ll_search:
                UIManager.turnToAct(getActivity(), NewsSearchActivity.class);
                break;
            case R.id.iv_right:
                UIManager.turnToAct(getActivity(), QiYeZhiXiaoAct.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
