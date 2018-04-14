package com.lcworld.shopdemo.pt.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.TGoodsCardCategoryActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QYShangZhuYeFrag extends BaseFragment {

    Unbinder unbinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.frag_qy_zhuye;
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


    @OnClick({R.id.ll_back, R.id.iv_1, R.id.iv_2, R.id.iv_3, R.id.iv_4,
            R.id.iv_5, R.id.iv_6, R.id.iv_7, R.id.iv_8})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                getActivity().finish();
                break;
            case R.id.iv_1:
                break;
            case R.id.iv_2:
                break;
            case R.id.iv_3:
                Bundle bundle3 = new Bundle();
                bundle3.putInt("flag", 4);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle3);
                break;
            case R.id.iv_4:
                Bundle bundle4 = new Bundle();
                bundle4.putInt("flag", 3);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle4);
                break;
            case R.id.iv_5:
                Bundle bundle1 = new Bundle();
                bundle1.putInt("flag", 2);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle1);
                break;
            case R.id.iv_6:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("flag", 2);
                UIManager.turnToAct(getActivity(), TGoodsCardCategoryActivity.class, bundle2);
                break;
            case R.id.iv_7:
                break;
            case R.id.iv_8:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
