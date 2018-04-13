package com.lcworld.shopdemo.rmq.fragment;

import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.Actionbar;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.rmq.activity.MainActivity;


/**
 * 创建：duke
 * 日期： 2017/4/14
 * 注释：私聊
 * 版本： 1.0.0
 */
public class SingleChatFragment extends BaseFragment implements Actionbar.ActionbarOnClickListener {

    @Override
    protected int setContentView() {
        return R.layout.fragment_chat;
    }

    @Override
    protected boolean setActionBarView() {
        return true;
    }


    @Override
    protected void initView(View view) {
        ImageView iv1 = (ImageView) view.findViewById(R.id.iv1);
        ImageView iv2 = (ImageView) view.findViewById(R.id.iv2);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                UIManager.turnToAct(getActivity(), SingleChatActivity.class);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                UIManager.turnToAct(getActivity(), SingleChatActivity.class);
            }
        });
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
        final MainActivity activity = (MainActivity) getActivity();
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.doMore(ivmore);
            }
        });


    }

    /**
     * 右上角的 搜索和三点
     * 0706中间加上一键呼叫
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
//                ((MainActivity) getActivity()).doMore(actionbar);
//            }
//        });
//        (view.findViewById(R.id.iv_add_fenzu)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("fenzuType", 0);//0私聊 1群聊 2人脉圈
//                UIManager.turnToAct(getActivity(), FenzuManageAct.class, bundle);
//            }
//        });
    }


    @Override
    protected void initData() {
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
