package com.lcworld.shopdemo.stq;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
public class CYDActivity extends BaseActivity {


    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.iv5)
    ImageView iv5;
    private Unbinder unbinder;

    @Override
    protected int setContentView() {
        return R.layout.s_act_cyd;
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

    @OnClick({R.id.ll_back, R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv1:
                setChoose(1);
                break;
            case R.id.tv2:
                setChoose(2);
                break;
            case R.id.tv3:
                setChoose(3);
                break;
            case R.id.tv4:
                setChoose(4);
                break;
            case R.id.tv5:
                setChoose(5);
                break;
        }
    }

    private void setChoose(int i) {
        tv1.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
        tv2.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
        tv3.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
        tv4.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
        tv5.setTextColor(getResources().getColor(R.color.gray_8b8b8b));
        iv1.setVisibility(View.GONE);
        iv2.setVisibility(View.GONE);
        iv3.setVisibility(View.GONE);
        iv4.setVisibility(View.GONE);
        iv5.setVisibility(View.GONE);
        switch (i) {
            case 1:
                tv1.setTextColor(getResources().getColor(R.color.theme_tsq));
                iv1.setVisibility(View.VISIBLE);
                break;
            case 2:
                tv2.setTextColor(getResources().getColor(R.color.theme_tsq));
                iv2.setVisibility(View.VISIBLE);
                break;
            case 3:
                tv3.setTextColor(getResources().getColor(R.color.theme_tsq));
                iv3.setVisibility(View.VISIBLE);
                break;
            case 4:
                tv4.setTextColor(getResources().getColor(R.color.theme_tsq));
                iv4.setVisibility(View.VISIBLE);
                break;
            case 5:
                tv5.setTextColor(getResources().getColor(R.color.theme_tsq));
                iv5.setVisibility(View.VISIBLE);
                break;
            default:
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
