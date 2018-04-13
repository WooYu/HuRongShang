package com.lcworld.shopdemo.sh.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.T_ShopMainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 商会-商城
 */
public class SSHMarketFragment extends BaseFragment {

    Unbinder unbinder;
    private int qhf = 1;
    private ImageView iva;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.s_frag_shmain_sc;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        iva = (ImageView) view.findViewById(R.id.iv);
    }


    @Override
    protected void initData() {
    }


    @Override
    protected void setListener() {

    }

    @OnClick({R.id.iv, R.id.qh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv:
                UIManager.turnToAct(getActivity(), T_ShopMainActivity.class);
                break;
            case R.id.qh:
                if (qhf == 1) {
                    qhf = 2;
                    iva.setImageResource(R.mipmap.shsc02);
                } else {
                    qhf = 1;
                    iva.setImageResource(R.mipmap.shsc03);
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
