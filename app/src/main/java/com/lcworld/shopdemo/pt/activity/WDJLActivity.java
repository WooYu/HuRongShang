package com.lcworld.shopdemo.pt.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.UIManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 社团圈-新闻详情
 */
public class WDJLActivity extends BaseActivity {


    @BindView(R.id.iv1)
    ImageView iv1;
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.act_wdjl;
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

    @OnClick({R.id.back, R.id.tdjz, R.id.wdjl, R.id.iv2, R.id.iv3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tdjz:
                Bundle bundle1 = new Bundle();
                bundle1.putInt("flag", 1);
                UIManager.turnToAct(this, TDJLActivity.class, bundle1);
                break;
            case R.id.wdjl:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("flag", 2);
                UIManager.turnToAct(this, TDJLActivity.class, bundle2);
                break;
            case R.id.iv2:
                UIManager.turnToAct(this, ZPDetailsActivity.class);
                break;
            case R.id.iv3:
                UIManager.turnToAct(this, ZPDetailsActivity.class);
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
