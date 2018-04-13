package com.lcworld.shopdemo.ybg.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.sh.activity.T_SHMainActivity;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity.T_ShopMainActivity;
import com.lcworld.shopdemo.ybg.activity.T_YBGMainActivity;
import com.lcworld.shopdemo.ybg.activity.YBGsettingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 商会-资讯
 */
public class SYBGMyFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
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
        return R.layout.s_frag_ybgmain_wd;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        final T_YBGMainActivity activity = (T_YBGMainActivity) getActivity();
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
        final ImageView ivset = (ImageView) view.findViewById(R.id.ivset);
        final LinearLayout ll_back = (LinearLayout) view.findViewById(R.id.ll_back);
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.doMore(ivmore);
            }
        });
        ivset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.turnToAct(getActivity(), YBGsettingActivity.class);
            }
        });
        if (flag == 1) {
            iv1.setImageResource(R.mipmap.hwwd1);
            iv2.setImageResource(R.mipmap.hwwd2);
            ll_back.setVisibility(View.VISIBLE);
            ll_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UIManager.turnToAct(getActivity(), T_SHMainActivity.class);
                }
            });
        } else {
            ll_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UIManager.turnToAct(getActivity(), T_ShopMainActivity.class);
                }
            });
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
