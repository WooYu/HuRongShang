package com.lcworld.shopdemo.stq.video.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 社团圈-视频模块-历史视频列表
 */
public class HistoryVideoActivity extends BaseActivity {

    @BindView(R.id.lv_content)
    ListView lvContent;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.ll_empty)
    LinearLayout llRmpty;
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.ll_edit)
    LinearLayout llEdit;

    private Unbinder unbinder;
    private List<String> mList;
    private boolean isEdit;  //是否编辑状态

    @Override
    protected int setContentView() {
        return R.layout.s_act_history_video;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }


    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
    }

    @Override
    protected void initData() {
    }


    @OnClick({R.id.ll_back, R.id.ll_edit, R.id.ll_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.ll_empty:

                break;
            case R.id.ll_search:

                break;
            case R.id.ll_edit:
                isEdit = !isEdit;
                if (isEdit) {
                    tvEdit.setText("完成");
                    llRmpty.setVisibility(View.VISIBLE);
                    llBack.setVisibility(View.GONE);
                } else {
                    tvEdit.setText("编辑");
                    llRmpty.setVisibility(View.GONE);
                    llBack.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
