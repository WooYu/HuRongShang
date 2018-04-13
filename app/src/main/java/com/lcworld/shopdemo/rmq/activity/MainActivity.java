package com.lcworld.shopdemo.rmq.activity;

import android.app.Activity;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.SelectMorePop;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.rmq.fragment.ContactFragment;
import com.lcworld.shopdemo.rmq.fragment.FriendsCircleFragment;
import com.lcworld.shopdemo.rmq.fragment.GroupChatFragment;
import com.lcworld.shopdemo.rmq.fragment.MyFragment;
import com.lcworld.shopdemo.rmq.fragment.SingleChatFragment;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.content_layout)
    FrameLayout contentLayout;
    @BindView(R.id.iv_bottom_01)
    ImageView ivBottom01;
    @BindView(R.id.tv_red_circle_01)
    TextView tvRedCircle01;
    @BindView(R.id.tv_bottom_01)
    TextView tvBottom01;
    @BindView(R.id.ll_bottom_01)
    LinearLayout llBottom01;
    @BindView(R.id.iv_bottom_02)
    ImageView ivBottom02;
    @BindView(R.id.tv_red_circle_02)
    TextView tvRedCircle02;
    @BindView(R.id.tv_bottom_02)
    TextView tvBottom02;
    @BindView(R.id.ll_bottom_02)
    LinearLayout llBottom02;
    @BindView(R.id.iv_bottom_03)
    ImageView ivBottom03;
    @BindView(R.id.tv_red_circle_03)
    TextView tvRedCircle03;
    @BindView(R.id.tv_bottom_03)
    TextView tvBottom03;
    @BindView(R.id.ll_bottom_03)
    LinearLayout llBottom03;
    @BindView(R.id.iv_bottom_04)
    ImageView ivBottom04;
    @BindView(R.id.tv_red_circle_04)
    TextView tvRedCircle04;
    @BindView(R.id.tv_bottom_04)
    TextView tvBottom04;
    @BindView(R.id.ll_bottom_04)
    LinearLayout llBottom04;
    @BindView(R.id.iv_bottom_05)
    ImageView ivBottom05;
    @BindView(R.id.tv_red_circle_05)
    TextView tvRedCircle05;
    @BindView(R.id.tv_bottom_05)
    TextView tvBottom05;
    @BindView(R.id.ll_bottom_05)
    LinearLayout llBottom05;
    @BindView(R.id.ll_all_bottom)
    LinearLayout llAllBottom;
    @BindView(R.id.btn_1)
    RadioButton btn1;
    @BindView(R.id.btn_2)
    RadioButton btn2;
    @BindView(R.id.btn_3)
    RadioButton btn3;
    @BindView(R.id.btn_4)
    RadioButton btn4;
    @BindView(R.id.btn_5)
    RadioButton btn5;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private Fragment newFragment;// 切换的页面
    private Fragment currentFragment;// 当前的页面
    private SingleChatFragment singleChatFragment;// 私聊
    private GroupChatFragment groupChatFragment;// 群聊
    private FriendsCircleFragment friendsCircleFragment;// 朋友圈
    private ContactFragment contactFragment;// 通讯录
    private MyFragment myFragment;// 我的
    public static Activity mMainActivity = null;

    @Override
    protected int setContentView() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        mMainActivity = this;
        ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);

    }


    @Override
    protected void initData() {
        setFragmentData();
    }

    //初始化 5个主页面
    private void setFragmentData() {
        singleChatFragment = new SingleChatFragment();
        currentFragment = singleChatFragment;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_layout, currentFragment).commitAllowingStateLoss();
        setChecked(1);
    }

    @Override
    protected void setListener() {
    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }


    private void setChecked(int i) {
        tvBottom01.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom01.setImageResource(R.mipmap.icon_single_normal);
        tvBottom02.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom02.setImageResource(R.mipmap.icon_group_normal);
        tvBottom03.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom03.setImageResource(R.mipmap.icon_circle_normal);
        tvBottom04.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom04.setImageResource(R.mipmap.icon_contact_normal);
        tvBottom05.setTextColor(getResources().getColor(R.color.gray_bottom_text));
        ivBottom05.setImageResource(R.mipmap.icon_my_normal);

        switch (i) {
            case 1:
                tvBottom01.setTextColor(getResources().getColor(R.color.actionbar_color));
                ivBottom01.setImageResource(R.mipmap.icon_single_checked);
                break;
            case 2:
                tvBottom02.setTextColor(getResources().getColor(R.color.actionbar_color));
                ivBottom02.setImageResource(R.mipmap.icon_group_checked);
                break;
            case 3:
                tvBottom03.setTextColor(getResources().getColor(R.color.actionbar_color));
                ivBottom03.setImageResource(R.mipmap.icon_circle_checked);
                break;
            case 4:
                tvBottom04.setTextColor(getResources().getColor(R.color.actionbar_color));
                ivBottom04.setImageResource(R.mipmap.icon_contact_checked);
                break;
            case 5:
                tvBottom05.setTextColor(getResources().getColor(R.color.actionbar_color));
                ivBottom05.setImageResource(R.mipmap.icon_my_checked);
                break;

            default:
                break;
        }

    }

    private void replaceFragment() {
        if (newFragment != currentFragment) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (newFragment.isAdded()) {
//                newFragment.onResume();
                transaction.show(newFragment);
            } else {
                transaction.add(R.id.content_layout, newFragment);
            }
            transaction.hide(currentFragment).commitAllowingStateLoss();
            currentFragment = newFragment;
        }
    }

    /**
     * 双击退出函数
     */
    private static Boolean isExit = false;

    public void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            showToast("再次点击将退出应用");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            Process.killProcess(Process.myPid());  //获取PID
            System.exit(0);   //返回值为0代表正常退出
        }
    }

    //切换5个主页面
    @OnClick({R.id.ll_bottom_01, R.id.ll_bottom_02, R.id.ll_bottom_03, R.id.ll_bottom_04, R.id.ll_bottom_05})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_bottom_01:
                if (singleChatFragment == null) {
                    singleChatFragment = new SingleChatFragment();
                }
                newFragment = singleChatFragment;
                replaceFragment();
                setChecked(1);
                break;
            case R.id.ll_bottom_02:
                if (groupChatFragment == null) {
                    groupChatFragment = new GroupChatFragment();
                }
                newFragment = groupChatFragment;
                replaceFragment();
                setChecked(2);
                break;
            case R.id.ll_bottom_03:
                if (friendsCircleFragment == null) {
                    friendsCircleFragment = new FriendsCircleFragment();
                }
                newFragment = friendsCircleFragment;
                replaceFragment();
                setChecked(3);
//                EventBus.getDefault().post(new EventRefreshBottomRedCircle(3, false));
                break;
            case R.id.ll_bottom_04:
                if (contactFragment == null) {
                    contactFragment = new ContactFragment();
                }
                newFragment = contactFragment;
                replaceFragment();
                setChecked(4);
                break;
            case R.id.ll_bottom_05:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                }
                newFragment = myFragment;
                replaceFragment();
                setChecked(5);
                break;
        }
    }

    //右上角三点
    public void doMore(View actionbar) {
        //弹出功能pop
        new SelectMorePop(MainActivity.this, new SelectMorePop.SelectCallBack() {
            @Override
            public void onSelected(int more_type) {
                switch (more_type) {
                    case 5:
                        UIManager.turnToAct(MainActivity.this, ChangeChatModeAct.class);
                        break;

                    default:
                        break;
                }
            }
        }).showAsDropDown(actionbar, 0, 0);

    }
}
