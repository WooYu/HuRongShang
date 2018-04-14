package com.lcworld.shopdemo.pt.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcworld.shopdemo.MessageEvent;
import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.AppConfig;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.activity.MainActivity;
import com.lcworld.shopdemo.sh.activity.OrdersActivity;
import com.lcworld.shopdemo.ybg.activity.T_YBGMainActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QYShangMineFrag extends BaseFragment {

    @BindView(R.id.unread_1)
    TextView unread1;
    @BindView(R.id.unread_2)
    TextView unread2;
    @BindView(R.id.unread_3)
    TextView unread3;
    @BindView(R.id.unread_4)
    TextView unread4;
    @BindView(R.id.unread_5)
    TextView unread5;
    Unbinder unbinder;


    @Override
    protected int setContentView() {
        return R.layout.fragment_qy_mine;
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

    @OnClick({R.id.ll_dingdan, R.id.ll_zj, R.id.ll_sc, R.id.ll_kf, R.id.ll_fhrmq,
            R.id.ll_zs, R.id.ll_zp, R.id.ll_dz, R.id.ll_xxzx, R.id.ll_gywm, R.id.ll_back,
            R.id.dingdan, R.id.ll_1, R.id.ll_2, R.id.ll_31, R.id.ll_4, R.id.ll_5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_fhrmq:
                AppConfig.getInstance().setMainType(0);
                UIManager.turnToAct(getActivity(), MainActivity.class);
                EventBus.getDefault().post(new MessageEvent());
            case R.id.ll_back:
                getActivity().finish();
                break;
            case R.id.dingdan:
                UIManager.turnToAct(getActivity(), OrdersActivity.class);
                break;
            case R.id.ll_dingdan:
                UIManager.turnToAct(getActivity(), OrdersActivity.class);
                break;
            case R.id.ll_1:
                break;
            case R.id.ll_2:
                break;
            case R.id.ll_31:
                break;
            case R.id.ll_4:
                break;
            case R.id.ll_5:
                break;
            case R.id.ll_zj:
                break;
            case R.id.ll_sc:
                break;
            case R.id.ll_kf:
                break;
            case R.id.ll_zs:
                Bundle bundle = new Bundle();
                bundle.putInt("aa", 0);
                UIManager.turnToAct(getActivity(), T_YBGMainActivity.class, bundle);
                break;
            case R.id.ll_zp:
                break;
            case R.id.ll_dz:
                break;
            case R.id.ll_xxzx:
                break;
            case R.id.ll_gywm:
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
