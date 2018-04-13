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
import com.lcworld.shopdemo.ybg.activity.KQActivity;
import com.lcworld.shopdemo.ybg.activity.T_YBGMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.lcworld.shopdemo.R.id.ll_back;


/**
 *
 */
public class SYBGtwoFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.aa)
    ImageView aa;
    @BindView(R.id.bb)
    ImageView bb;
    @BindView(R.id.ll1)
    LinearLayout ll1;
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
        return R.layout.s_frag_ybgmain_t;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
        final ImageView kq = (ImageView) view.findViewById(R.id.kq);
        final LinearLayout ll_main = (LinearLayout) view.findViewById(R.id.ll_main);
        final T_YBGMainActivity activity = (T_YBGMainActivity) getActivity();
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.doMore(ivmore);
            }
        });
        kq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.turnToAct(getActivity(), KQActivity.class);
            }
        });
        if (flag == 1) {
            aa.setVisibility(View.GONE);
            ll1.setVisibility(View.GONE);
            bb.setVisibility(View.VISIBLE);
            ll_main.setVisibility(View.VISIBLE);
            ll_main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UIManager.turnToAct(getActivity(), T_SHMainActivity.class);
                }
            });
        } else {
            ll_main.setOnClickListener(new View.OnClickListener() {
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
