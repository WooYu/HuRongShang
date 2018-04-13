package com.lcworld.shopdemo.base;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.lcworld.shopdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xinshuai on 2017/6/2.
 * 右上角选择扫一扫 二维码 添加人脉号 等等pop
 */

public class SelectMorePop extends BasePopup {
    @BindView(R.id.ll_qr_scan)
    LinearLayout llQrScan;
    @BindView(R.id.ll_qr_code)
    LinearLayout llQrCode;
    @BindView(R.id.ll_add_rm)
    LinearLayout llAddRm;
    @BindView(R.id.ll_make_group)
    LinearLayout llMakeGroup;
    @BindView(R.id.ll_edit_fenzu)
    LinearLayout llEditFenzu;
    @BindView(R.id.ll_change_mode)
    LinearLayout llChangeMode;
    @BindView(R.id.ll_yjhj_setting)
    LinearLayout llYjhjSetting;


    private SelectCallBack callBack;

    public SelectMorePop(Activity activity, SelectCallBack callBack) {
        super(activity, R.layout.pop_select_more);
        this.callBack = callBack;
    }

    @Override
    public void initView() {
        super.initView();
        ButterKnife.bind(this, contentView);
//        // 设置窗口宽度
//        setWidth(DisplayUtil.dip2px(activity, 200));
//        // 设置窗口高度
//        setHeight(DisplayUtil.dip2px(activity, 60 * 7));
    }

    @OnClick({R.id.ll_qr_scan, R.id.ll_qr_code, R.id.ll_add_rm, R.id.ll_make_group,
            R.id.ll_edit_fenzu, R.id.ll_change_mode, R.id.ll_yjhj_setting,
            R.id.view_dismiss_01,R.id.view_dismiss_02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_qr_scan:
                callBack.onSelected(0);
                break;
            case R.id.ll_qr_code:
                callBack.onSelected(1);
                break;
            case R.id.ll_add_rm:
                callBack.onSelected(2);
                break;
            case R.id.ll_make_group:
                callBack.onSelected(3);
                break;
            case R.id.ll_edit_fenzu:
                callBack.onSelected(4);
                break;
            case R.id.ll_change_mode:
                callBack.onSelected(5);
                break;
            case R.id.ll_yjhj_setting:
                callBack.onSelected(6);
                break;
            case R.id.view_dismiss_01:
            case R.id.view_dismiss_02:
                break;
        }
        dismiss();
    }

    public interface SelectCallBack {
        /**
         * 选择
         */
        public void onSelected(int more_type);

    }


}
