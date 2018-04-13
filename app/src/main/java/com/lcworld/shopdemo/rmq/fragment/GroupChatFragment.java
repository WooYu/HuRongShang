package com.lcworld.shopdemo.rmq.fragment;

import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.Actionbar;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.rmq.activity.MainActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 创建：duke
 * 日期： 2017/4/14
 * 注释：群聊
 * 版本： 1.0.0
 */
public class GroupChatFragment extends BaseFragment implements Actionbar.ActionbarOnClickListener {
    Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.fragment_chat_group;
    }

    @Override
    protected boolean setActionBarView() {
        return true;
    }

    @Override
    protected void initView(View view) {
        //title
        unbinder = ButterKnife.bind(view);
        final MainActivity activity = (MainActivity) getActivity();
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    protected void setListener() {
    }

    @Override
    public void rightOnClickListener(View v) {
    }

    @Override
    public void leftOnClickListener(View v) {

    }

    /**
     * 右上角的 搜索和三点
     *
     * @param view
     */
    private void initRightTwo(View view) {
//        (view.findViewById(R.id.ll_search)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UIManager.turnToAct(getActivity(), SearchAct.class);
//            }
//        });
//        //查看一键呼叫按钮
//        (view.findViewById(R.id.rl_yjhj)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UIManager.turnToAct(getActivity(), YJHJListAct.class);
//            }
//        });
//        (view.findViewById(R.id.ll_more)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //弹出功能pop
//                ((MainActivity) getActivity()).doMore(actionbar);
//            }
//        });
//        (view.findViewById(R.id.iv_add_fenzu)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("fenzuType", 1);//0私聊 1群聊 2人脉圈
//                UIManager.turnToAct(getActivity(), FenzuManageAct.class, bundle);
//            }
//        });
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }


}
