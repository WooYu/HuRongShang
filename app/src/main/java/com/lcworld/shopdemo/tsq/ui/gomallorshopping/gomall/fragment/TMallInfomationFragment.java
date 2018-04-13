package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.stq.headline.activity.NewsDetailsActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.activity.T_MarketMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈-商铺-资讯
 */
public class TMallInfomationFragment extends BaseFragment {

    @BindView(R.id.shangchang)
    TextView shangchang;
    @BindView(R.id.shangjia)
    TextView shangjia;
    Unbinder unbinder;
    private T_MarketMainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (T_MarketMainActivity) context;
    }

    @Override
    protected int setContentView() {
        return R.layout.t_frag_markmain_zx;
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

    @OnClick({R.id.ll_back, R.id.iv_search, R.id.iv_history, R.id.shangchang, R.id.shangjia, R.id.iv1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                getActivity().finish();
                break;
            case R.id.iv_search:
                break;
            case R.id.iv_history:
                break;
            case R.id.shangchang:
                break;
            case R.id.shangjia:
                break;
            case R.id.iv1:
                UIManager.turnToAct(getActivity(), NewsDetailsActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
