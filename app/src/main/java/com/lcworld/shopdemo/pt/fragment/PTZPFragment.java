package com.lcworld.shopdemo.pt.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.pt.activity.T_PTMainActivity;
import com.lcworld.shopdemo.pt.activity.WDJLActivity;
import com.lcworld.shopdemo.pt.activity.ZPDetailsActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 拓商圈-社区圈
 */
public class PTZPFragment extends BaseFragment {

    Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.t_frag_main_ptzp;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
        final T_PTMainActivity activity = (T_PTMainActivity) getActivity();
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.doMore(ivmore);
            }
        });
    }


    @Override
    protected void initData() {
    }


    @Override
    protected void setListener() {

    }

    @OnClick({R.id.iv, R.id.jianli})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv:
                UIManager.turnToAct(getActivity(), ZPDetailsActivity.class);
                break;
            case R.id.jianli:
                UIManager.turnToAct(getActivity(), WDJLActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
