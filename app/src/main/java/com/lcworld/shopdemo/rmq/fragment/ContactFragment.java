package com.lcworld.shopdemo.rmq.fragment;

import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseFragment;
import com.lcworld.shopdemo.rmq.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建：duke
 * 日期： 2017/4/14
 * 注释：通讯录
 * 版本： 1.0.0
 */
public class ContactFragment extends BaseFragment {


    private ImageView iv11;
    private ImageView iv22;
    private ImageView iv33;
    private ImageView iv44;
    private ImageView iv55;
    private ImageView iv66;
    private ImageView iv77;
    private ImageView iv1;
    private ImageView ivTitle;
    Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.fragment_contact;
    }

    @Override
    protected boolean setActionBarView() {
        return true;
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(view);
        iv1 = (ImageView) view.findViewById(R.id.iv1);
        iv11 = (ImageView) view.findViewById(R.id.iv11);
        iv22 = (ImageView) view.findViewById(R.id.iv22);
        iv33 = (ImageView) view.findViewById(R.id.iv33);
        iv44 = (ImageView) view.findViewById(R.id.iv44);
        iv55 = (ImageView) view.findViewById(R.id.iv55);
        iv66 = (ImageView) view.findViewById(R.id.iv66);
        iv77 = (ImageView) view.findViewById(R.id.iv77);
        ivTitle = (ImageView) view.findViewById(R.id.iv_title);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(1);
            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(2);
            }
        });
        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(3);
            }
        });
        iv44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(4);
            }
        });
        iv55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(5);
            }
        });
        iv66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(6);
            }
        });
        iv77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(7);
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
//        mActionbar.setListener(new Actionbar.ActionbarOnClickListener() {
//            @Override
//            public void rightOnClickListener(View v) {
//            }
//
//            @Override
//            public void leftOnClickListener(View v) {
//
//            }
//        });
//        //title
//        mActionbar.setTitleTxt("云薄");
//        initRightTwo(view);
//        mViewPager.setCurrentItem(4);

        /**
         * 右上角的 搜索和三点
         *
         * @param view
         */
//    private void initRightTwo(View view) {
//        (view.findViewById(R.id.ll_search)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UIManager.turnToAct(getActivity(), SearchAct.class);
//            }
//        });
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
//                ((MainActivity) getActivity()).doMore(mActionbar);
//
//            }
//        });
//    }

//
//        @OnClick({R.id.ll_add_rm, R.id.ll_new_friend_fragment_friends, R.id.ll_black})
//        public void onClick (View view){
//            switch (view.getId()) {
//                case R.id.ll_add_rm:
//                    UIManager.turnToAct(getActivity(), AddSthActivity.class);
//                    break;
//                case R.id.ll_new_friend_fragment_friends:
//                    EventBus.getDefault().post(new EventRefreshBottomRedCircle(4, false));
//                    ActivitySkipUtil.skip(getActivity(), NewFriendsActivity.class);
//                    break;
//                case R.id.ll_black:
//                    UIManager.turnToAct(getActivity(), BlackListAct.class);
//                    break;
//            }
//        }
    }

//    @OnClick({R.id.iv11, R.id.iv22, R.id.iv33, R.id.iv44, R.id.iv55, R.id.iv66, R.id.iv77})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.iv11:
//                setData(1);
//                break;
//            case R.id.iv22:
//                setData(2);
//                break;
//            case R.id.iv33:
//                setData(3);
//                break;
//            case R.id.iv44:
//                setData(4);
//                break;
//            case R.id.iv55:
//                setData(5);
//                break;
//            case R.id.iv66:
//                setData(6);
//                break;
//            case R.id.iv77:
//                setData(7);
//                break;
//        }
//    }

    private void setData(int i) {
        iv11.setImageResource(R.mipmap.yb1a);
        iv22.setImageResource(R.mipmap.yb2a);
        iv33.setImageResource(R.mipmap.yb3a);
        iv44.setImageResource(R.mipmap.yb4a);
        iv55.setImageResource(R.mipmap.yb5a);
        iv66.setImageResource(R.mipmap.yb6a);
        iv77.setImageResource(R.mipmap.yb7a);
        switch (i) {
            case 1://人脉号
                iv11.setImageResource(R.mipmap.yb1b);
                iv1.setImageResource(R.mipmap.shejiaoquan_content_rmq);
                ivTitle.setImageResource(R.mipmap.shejiaoquan_title_rmh);
                break;
            case 2://社团号
                iv22.setImageResource(R.mipmap.yb2b);
                iv1.setImageResource(R.mipmap.shejiaoquan_content_sth);
                ivTitle.setImageResource(R.mipmap.shejiaoquan_title_sth);
                break;
            case 3://企业号
                iv33.setImageResource(R.mipmap.yb3b);
                iv1.setImageResource(R.mipmap.shejiaoquan_content_qyh);
                ivTitle.setImageResource(R.mipmap.shejiaoquan_title_qyh);
                break;
            case 4://商家号
                iv44.setImageResource(R.mipmap.yb4b);
                iv1.setImageResource(R.mipmap.shejiaoquan_content_sjh);
                ivTitle.setImageResource(R.mipmap.shejiaoquan_title_sjh);
                break;
            case 5://创业号
                iv55.setImageResource(R.mipmap.yb5b);
                iv1.setImageResource(R.mipmap.yb5c);
                break;
            case 6://电话簿
                iv66.setImageResource(R.mipmap.yb6b);
                iv1.setImageResource(R.mipmap.yb6c);
                break;
            case 7://地址簿
                iv77.setImageResource(R.mipmap.yb7b);
                iv1.setImageResource(R.mipmap.shejiaoquan_content_dzp);
                ivTitle.setImageResource(R.mipmap.shejiaoquan_title_dzp);
                break;
            default:
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
