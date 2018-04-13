package com.lcworld.shopdemo.stq.headline.activity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.UIManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 搜索页面
 */
public class NewsSearchActivity extends BaseActivity {

    @BindView(R.id.ll_input_click)
    LinearLayout llInputClick;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.ll_del)
    LinearLayout llDel;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.lv_content)
    ListView lvContent;

    private Unbinder unbinder;
    private List<String> mList;
    private String content;

    @Override
    protected int setContentView() {
        return R.layout.s_act_search;
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);

    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            content = bundle.getString("content");
        }
    }

    @Override
    protected void setListener() {
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == 0 || actionId == 3) && event != null) {
                    search();
                }
                return false;
            }
        });
//        UIManager.turnToAct(NewsSearchActivity.this, NewsDetailsActivity.class);
    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }

    @OnClick({R.id.tv_cancel, R.id.ll_del, R.id.ll_input_click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.ll_del:
                etSearch.setText("");
                break;
            case R.id.ll_input_click:
                search();
                break;
        }
    }

    /**
     * 搜索
     */
    public void search() {
        String text = etSearch.getText().toString();
        if (TextUtils.isEmpty(text)) {
            showToast("请先输入搜索内容");
            return;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
