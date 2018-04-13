package com.lcworld.shopdemo.ybg.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.UIManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class KQActivity extends BaseActivity {


    @BindView(R.id.sb1)
    TextView sb1;
    @BindView(R.id.sb2)
    TextView sb2;
    @BindView(R.id.sb3)
    ImageView sb3;
    @BindView(R.id.sb4)
    TextView sb4;
    @BindView(R.id.xb1)
    TextView xb1;
    @BindView(R.id.xb2)
    TextView xb2;
    @BindView(R.id.xb3)
    TextView xb3;
    @BindView(R.id.sq1)
    ImageView sq1;
    @BindView(R.id.qj1)
    ImageView qj1;
    @BindView(R.id.jb1)
    ImageView jb1;
    @BindView(R.id.bk1)
    ImageView bk1;
    @BindView(R.id.xb4)
    ImageView xb4;
    @BindView(R.id.no)
    ImageView no;
    @BindView(R.id.yes)
    ImageView yes;
    @BindView(R.id.neirong)
    ScrollView neirong;
    @BindView(R.id.tanchaung)
    LinearLayout tanchaung;
    private Unbinder unbinder;
    private int isSXB = 1;
    private int isSQ = 1;

    @Override
    protected int setContentView() {
        return R.layout.y_act_kq;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }


    @Override
    protected void initData() {
    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.back, R.id.no, R.id.yes, R.id.ls, R.id.sb4, R.id.xb3, R.id.sq1, R.id.qj1, R.id.jb1, R.id.bk1, R.id.kq1, R.id.tj1, R.id.pm1, R.id.gl1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ls:
                UIManager.turnToAct(this, KQTXActivity.class);
                break;
            case R.id.yes:
                if (isSXB == 1) {
                    sb1.setTextColor(getResources().getColor(R.color.holo_red_light));
                    sb2.setTextColor(getResources().getColor(R.color.holo_red_light));
                    sb3.setVisibility(View.VISIBLE);
                    sb4.setBackgroundResource(R.drawable.bg_gray_round);
                    xb1.setTextColor(getResources().getColor(R.color.ybgblue));
                    xb2.setTextColor(getResources().getColor(R.color.ybgblue));
                    xb3.setBackgroundResource(R.drawable.bg_blue_round);
                    xb4.setVisibility(View.GONE);
                } else {
                    sb1.setTextColor(getResources().getColor(R.color.ybgblue));
                    sb2.setTextColor(getResources().getColor(R.color.ybgblue));
                    sb3.setVisibility(View.GONE);
                    sb4.setBackgroundResource(R.drawable.bg_blue_round);
                    xb1.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
                    xb2.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
                    xb3.setBackgroundResource(R.drawable.bg_gray_round);
                    xb4.setVisibility(View.VISIBLE);
                }
                tanchaung.setVisibility(View.GONE);
                break;
            case R.id.no:
                tanchaung.setVisibility(View.GONE);
                break;
            case R.id.sb4:
                tanchaung.setVisibility(View.VISIBLE);
                isSXB = 1;
                break;
            case R.id.xb3:
                tanchaung.setVisibility(View.VISIBLE);
                isSXB = 2;

                break;
            case R.id.sq1:
                if (isSQ == 1) {
                    isSQ = 2;
                    qj1.setVisibility(View.VISIBLE);
                    jb1.setVisibility(View.VISIBLE);
                    bk1.setVisibility(View.VISIBLE);
                } else {
                    isSQ = 1;
                    qj1.setVisibility(View.GONE);
                    jb1.setVisibility(View.GONE);
                    bk1.setVisibility(View.GONE);
                }
                break;
            case R.id.qj1:
                Bundle bundle1 = new Bundle();
                bundle1.putInt("flag", 1);
                UIManager.turnToAct(this, QJActivity.class, bundle1);
                break;
            case R.id.jb1:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("flag", 2);
                UIManager.turnToAct(this, QJActivity.class, bundle2);
                break;
            case R.id.bk1:
                Bundle bundle3 = new Bundle();
                bundle3.putInt("flag", 3);
                UIManager.turnToAct(this, QJActivity.class, bundle3);
                break;
            case R.id.kq1:
                break;
            case R.id.tj1:
                Bundle bundle4 = new Bundle();
                bundle4.putInt("flag", 4);
                UIManager.turnToAct(this, QJActivity.class, bundle4);
                break;
            case R.id.pm1:
                Bundle bundle5 = new Bundle();
                bundle5.putInt("flag", 5);
                UIManager.turnToAct(this, QJActivity.class, bundle5);
                break;
            case R.id.gl1:
                Bundle bundle6 = new Bundle();
                bundle6.putInt("flag", 6);
                UIManager.turnToAct(this, QJActivity.class, bundle6);
                break;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
