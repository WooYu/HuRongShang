package com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.pt.activity.QiYeMerchantAct;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.GoodsDetailActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.TGoodsCardCategoryActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.T_QYMainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈-商店-首页
 */
public class TShopHomeFragment extends BaseFragment {

    Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.t_frag_shopmain_home;
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


    @OnClick({R.id.ll_back, R.id.iv35, R.id.iv31, R.id.iv32, R.id.iv33, R.id.iv34, R.id.iv6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                getActivity().finish();
                break;
            case R.id.iv35:
                UIManager.turnToAct(getActivity(), QiYeMerchantAct.class);

                break;
            case R.id.iv31:
                Bundle bundle1 = new Bundle();
                bundle1.putInt("flag", 1);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle1);
                break;
            case R.id.iv32:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("flag", 2);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle2);
                break;
            case R.id.iv33:
                Bundle bundle3 = new Bundle();
                bundle3.putInt("flag", 3);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle3);
                break;
            case R.id.iv34:
                Bundle bundle4 = new Bundle();
                bundle4.putInt("flag", 4);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle4);
                break;
            case R.id.iv6:
                UIManager.turnToAct(getActivity(), GoodsDetailActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
