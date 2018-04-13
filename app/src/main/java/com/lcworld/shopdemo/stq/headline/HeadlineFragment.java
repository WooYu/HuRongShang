package com.lcworld.shopdemo.stq.headline;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.activity.MainActivity;
import com.lcworld.shopdemo.stq.S_MainActivity;
import com.lcworld.shopdemo.stq.headline.activity.NewsDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 社团圈-头条模块首页
 */
public class HeadlineFragment extends BaseFragment {

    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.ll_search_click)
    LinearLayout llSearchClick;
    @BindView(R.id.ll_more)
    LinearLayout llMore;
    @BindView(R.id.ll_search_normal)
    LinearLayout llSearchNormal;
    @BindView(R.id.iv2)
    ImageView iv2;

    Unbinder unbinder;
    //    private MyMorePop morePopnew;
    private S_MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (S_MainActivity) context;
    }

    @Override
    protected int setContentView() {
        return R.layout.s_frag_headline;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.turnToAct(getActivity(), NewsDetailsActivity.class);
            }
        });
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
     * 标题集合
     */

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }


    @OnClick({R.id.ll_search_click, R.id.ll_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_search_click:
                if (activity != null) {
                    activity.showSearch();
                }
                break;
            case R.id.ll_more:
//                if (morePopnew == null) {
//                    morePopnew = new MyMorePop(getActivity(), new MyMorePop.SelectCallBack() {
//                        @Override
//                        public void onSelected(String type) {
//
//                        }
//                    });
//                }
//                morePopnew.show(llMore);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
