package com.lcworld.shopdemo.rmq.activity;

import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.Actionbar;
import com.lcworld.shopdemo.base.AppConfig;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.pt.activity.T_PTMainActivity;
import com.lcworld.shopdemo.stq.S_MainActivity;
import com.lcworld.shopdemo.tsq.ui.main.activity.T_MainActivity;
import com.lcworld.shopdemo.ybg.activity.T_YBGMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 切换版本  默认个人版    和以前普通版交换
 */

public class ChangeChatModeAct extends BaseActivity {
    @BindView(R.id.actionbar)
    Actionbar actionbar;
    @BindView(R.id.iv_rmq)
    ImageView ivRmq;
    @BindView(R.id.iv_tsq)
    ImageView ivTsq;
    @BindView(R.id.iv_stq)
    ImageView ivStq;
    @BindView(R.id.iv_ybg)
    ImageView ivYbg;
    private int tempMainType;


    @Override
    protected int setContentView() {
        return R.layout.act_change_chat_mode;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }

    @Override
    protected void initData() {
        //切换主要版本 -- 默认是0人脉聊天  1拓商圈   2社团圈   3移动办公
        tempMainType = AppConfig.getInstance().getMainType();
        setOpen(tempMainType);
    }

    private void setOpen(int position) {
        ivRmq.setImageResource(position == 0 ? R.mipmap.icon_open : R.mipmap.icon_close);
        ivTsq.setImageResource(position == 1 ? R.mipmap.icon_open : R.mipmap.icon_close);
        ivStq.setImageResource(position == 2 ? R.mipmap.icon_open : R.mipmap.icon_close);
        ivYbg.setImageResource(position == 3 ? R.mipmap.icon_open : R.mipmap.icon_close);
    }

    @Override
    protected void setListener() {
        actionbar.setListener(new Actionbar.ActionbarOnClickListener() {
            @Override
            public void rightOnClickListener(View v) {

            }

            @Override
            public void leftOnClickListener(View v) {
                doFinishSth();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        doFinishSth();
    }

    /**
     * 判断和进来时候一样不,一样不做操作 不一样切换版本,通知之前的关闭
     */
    private void doFinishSth() {
        if (tempMainType == AppConfig.getInstance().getMainType()) {
            finish();
        } else {
            int type = AppConfig.getInstance().getMainType();
            //默认是0人脉聊天  1拓商圈   2社团圈   3移动办公
            switch (type) {
                case 0:
                    MainActivity.mMainActivity.finish();
                    break;
                case 1:
                    T_MainActivity.mMainActivity.finish();
                    break;
                case 2:
                    S_MainActivity.mMainActivity.finish();
                    break;
                case 3:
                    T_PTMainActivity.mMainActivity.finish();
                    T_YBGMainActivity.mMainActivity.finish();
                    break;
                default:
                    break;
            }
            //默认是0人脉聊天  1拓商圈   2社团圈   3移动办公
            AppConfig.getInstance().setMainType(tempMainType);
            switch (tempMainType) {
                case 0:
                    UIManager.turnToAct(this, MainActivity.class);
                    break;
                case 1:
                    UIManager.turnToAct(this, T_MainActivity.class);
                    break;
                case 2:
                    UIManager.turnToAct(this, S_MainActivity.class);
                    break;
                case 3:
                    UIManager.turnToAct(this, T_PTMainActivity.class);
                    break;
                default:
                    break;
            }
            finish();
        }
    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @OnClick({R.id.iv_rmq, R.id.iv_tsq, R.id.iv_stq, R.id.iv_ybg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_rmq:
                tempMainType = 0;
                break;
            case R.id.iv_tsq:
                tempMainType = 1;
                break;
            case R.id.iv_stq:
                tempMainType = 2;
                break;
            case R.id.iv_ybg:
                tempMainType = 3;
                break;
        }
        setOpen(tempMainType);
    }
}
