package com.lcworld.shopdemo.sh.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.lcworld.shopdemo.MessageEvent;
import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.AppConfig;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.activity.MainActivity;
import com.lcworld.shopdemo.sh.activity.OrdersActivity;
import com.lcworld.shopdemo.ybg.activity.T_YBGMainActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 商会-资讯
 */
public class SSHMyFragment extends BaseFragment {

    Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.s_frag_shmain_wd;
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

    @OnClick({R.id.ll_back, R.id.dingdan, R.id.ll_zs,R.id.ll_fhrmq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                getActivity().finish();
                break;
            case R.id.dingdan:
                UIManager.turnToAct(getActivity(), OrdersActivity.class);
                break;
            case R.id.ll_zs:
                Bundle bundle = new Bundle();
                bundle.putInt("aa", 1);
                UIManager.turnToAct(getActivity(), T_YBGMainActivity.class, bundle);
                break;
            case R.id.ll_fhrmq:
                AppConfig.getInstance().setMainType(0);
                UIManager.turnToAct(getActivity(), MainActivity.class);
                EventBus.getDefault().post(new MessageEvent());
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
