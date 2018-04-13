package com.lcworld.shopdemo.ybg.activity;


import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class QJActivity extends BaseActivity {


    private Unbinder unbinder;
    private ImageView iv1;
    private ImageView iv2;

    @Override
    protected int setContentView() {
        return R.layout.y_act_qj;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);

    }


    @Override
    protected void initData() {
        int flag = getIntent().getIntExtra("flag", 1);
        switch (flag) {
            case 1://请假
                iv1.setImageResource(R.mipmap.qj001);
                iv2.setImageResource(R.mipmap.qj002);
                break;
            case 2://加班
                iv1.setImageResource(R.mipmap.jb001);
                iv2.setImageResource(R.mipmap.jb002);
                break;
            case 3://补卡
                iv1.setImageResource(R.mipmap.bk001);
                iv2.setImageResource(R.mipmap.bk002);
                break;
            case 4://统计
                iv1.setImageResource(R.mipmap.tongji1);
                iv2.setVisibility(View.GONE);
                break;
            case 5://排名
                iv1.setImageResource(R.mipmap.paiming1);
                iv2.setVisibility(View.GONE);
                break;
            case 6://管理
                iv1.setImageResource(R.mipmap.guanli1);
                iv2.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void setListener() {

    }

    @OnClick({R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
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
