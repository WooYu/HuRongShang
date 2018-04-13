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
 * 注释：朋友圈
 * 版本： 1.0.0
 */
public class FriendsCircleFragment extends BaseFragment implements View.OnClickListener, Actionbar.ActionbarOnClickListener, Actionbar.ActionBarOnLongClickListener {


    @Override
    protected int setContentView() {
        return R.layout.fragment_friends_circle;
    }

    @Override
    protected boolean setActionBarView() {
        return true;
    }

    @Override
    protected void initView(View view) {
//        initRightTwo(view);
        final ImageView ivmore = (ImageView) view.findViewById(R.id.ivmore);
        final MainActivity activity = (MainActivity) getActivity();
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


    /**
     * 右上角的 搜索和三点
     *
     * @param
     */
//    private void initRightTwo(View view) {
//        //设置相机icon
//        ((ImageView) view.findViewById(R.id.iv_right_01)).setImageResource(R.mipmap.icon_top_circle);
//        //单击
////        (view.findViewById(R.id.ll_search)).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                showSelectDialot();
////            }
////        });
//        (view.findViewById(R.id.ll_search)).setVisibility(View.GONE);
//        //长按
//        (view.findViewById(R.id.ll_search)).setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Bundle args = new Bundle();
//                args.putBoolean("LONGCLICK", true);
//                UIManager.turnToAct(getActivity(), PublishNewsActivity.class, args);
//                return true;
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
//                //弹出功能pop
//                ((MainActivity) getActivity()).doMore(mActionbar);
//            }
//        });
//        (view.findViewById(R.id.iv_add_fenzu)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("fenzuType", 2);//0私聊 1群聊 2人脉圈
//                UIManager.turnToAct(getActivity(), FenzuManageAct.class, bundle);
//            }
//        });
//    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }


    @Override
    public void rightOnClickListener(View v) {
//        showSelectDialot();
    }

    /**
     * 显示选择框
     */
//    private void showSelectDialot() {
//        MDDialog.Builder builder = new MDDialog.Builder(getActivity());
//        final MDDialog dialog = builder.create();
//        builder.setContentView(R.layout.dialog_elect_photo).setContentViewOperator(new MDDialog.ContentViewOperator() {
//            @Override
//            public void operate(View contentView) {
//                LinearLayout tvShoot = (LinearLayout) contentView.findViewById(R.id.ll_shoot_pop);
//                TextView tvPhotoAlbum = (TextView) contentView.findViewById(R.id.tv_photo_album_pop);
//                TextView tvWord = (TextView) contentView.findViewById(R.id.tv_word_album_pop);
//                //文字
//                tvWord.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Bundle args = new Bundle();
//                        args.putBoolean("LONGCLICK", true);
//                        UIManager.turnToAct(getActivity(), PublishNewsActivity.class, args);
//                        dialog.dismiss();
//                    }
//                });
//                //拍摄
//                tvShoot.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        ActivitySkipUtil.skip(getActivity(), UseCameraActivity.class);
//                        dialog.dismiss();
//                    }
//                });
//                //从相册选择图片
//                tvPhotoAlbum.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        selectPhoto();
//                        dialog.dismiss();
//                    }
//                });
//            }
//        }).setShowTitle(false).setShowButtons(false);
//        dialog.show();
//    }
    @Override
    public void leftOnClickListener(View v) {

    }

    @Override
    public void setOnLongClickListener(View view) {
    }


    //一键呼叫未读消息end
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
