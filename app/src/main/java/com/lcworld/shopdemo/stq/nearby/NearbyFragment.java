package com.lcworld.shopdemo.stq.nearby;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.stq.S_MainActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.activity.T_MarketMainActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 社团圈-附近模块首页
 */
public class NearbyFragment extends BaseFragment {

    Unbinder unbinder;
    private S_MainActivity activity;
//    private MyMorePop morePopnew;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (S_MainActivity) context;
    }

    @Override
    protected int setContentView() {
        return R.layout.s_frag_nearby;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
        final S_MainActivity activity = (S_MainActivity) getActivity();
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.doMore(ivmore);
            }
        });
    }


    /**
     * fragment集合
     */

    @OnClick({R.id.iv1, R.id.iv2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv1:
                UIManager.turnToAct(getActivity(), T_MarketMainActivity.class);
                break;
            case R.id.iv2:
                UIManager.turnToAct(getActivity(), T_MarketMainActivity.class);
                break;
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
