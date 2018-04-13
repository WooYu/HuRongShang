package com.lcworld.shopdemo.pt.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 社团圈-新闻详情
 */
public class TDJLActivity extends BaseActivity {


    @BindView(R.id.iv1)
    ImageView iv1;
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.act_tdjl;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
        int flag = getIntent().getExtras().getInt("flag");
        switch (flag) {
            case 1:
                iv1.setImageResource(R.mipmap.tdjz);
                break;
            case 2:
                iv1.setImageResource(R.mipmap.wdjljl);
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
