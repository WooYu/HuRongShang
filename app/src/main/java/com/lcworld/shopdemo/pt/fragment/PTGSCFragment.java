package com.lcworld.shopdemo.pt.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.pt.activity.T_PTMainActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 拓商圈-社区圈
 */
public class PTGSCFragment extends BaseFragment {

    Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected int setContentView() {
        return R.layout.t_frag_main_b2b;
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

//    @OnClick({R.id.iv})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.iv:
//                break;
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
