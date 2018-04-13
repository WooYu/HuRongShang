package com.lcworld.shopdemo.ybg.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.AppConfig;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.activity.MainActivity;
import com.lcworld.shopdemo.sh.activity.T_SHMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 商会-资讯
 */
public class SYBGoneFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.ll_back2)
    LinearLayout ll_back2;
    Unbinder unbinder1;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private int flag = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.s_frag_ybgmain_o;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        if (flag == 1) {
            iv1.setImageResource(R.mipmap.xxa);
            iv2.setImageResource(R.mipmap.xxb);
        }
    }


    @Override
    protected void initData() {
    }


    @Override
    protected void setListener() {

    }

    @OnClick({R.id.ll_back, R.id.ll_back2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                AppConfig.getInstance().setMainType(0);
                UIManager.turnToAct(getActivity(), MainActivity.class);
                getActivity().finish();
                break;
            case R.id.ll_back2:
                UIManager.turnToAct(getActivity(), T_SHMainActivity.class);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
