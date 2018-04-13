package com.lcworld.shopdemo.base;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.PopupWindow;


public abstract class BasePopup extends PopupWindow {

    public Activity activity;
    public View contentView;

    public BasePopup(Activity activity, int resource) {
        this.activity = activity;
        this.contentView = View.inflate(activity, resource, null);

        initView();
    }

    /**
     * 初始化页面
     */
    public void initView() {
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                // 隐藏阴影
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = 1f;
                activity.getWindow().setAttributes(lp);
            }
        });
        // 设置窗口界面
        setContentView(contentView);
        // 设置窗口宽度
        setWidth(LayoutParams.MATCH_PARENT);
        // 设置窗口高度
        setHeight(LayoutParams.MATCH_PARENT);
        // 设置点窗口以外的区域关闭窗口
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        setFocusable(true);
        // 添加动画AddCarPopup.java
//        setAnimationStyle(R.style.popwin_anim_up);
    }



    /**
     * 显示页面
     */
    public void showShadow() {
        // 显示阴影
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 0.6f;
        activity.getWindow().setAttributes(lp);
    }
    //popWindow 在Android7.0上的显示位置不管怎么设置都在屏幕的顶部，这是7.0的bug，
    // 已在7.1修复，但是7.0还是需要我们自己解决的，方法如下：
    @Override
    public void showAsDropDown(View anchorView, int xoff, int yoff) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N) {
            int[] a = new int[2];
            anchorView.getLocationInWindow(a);
            showAtLocation(anchorView, Gravity.NO_GRAVITY, xoff, a[1] + anchorView.getHeight() + yoff);
        } else {
            super.showAsDropDown(anchorView, xoff, yoff);
        }
    }

    @Override
    public void showAsDropDown(View anchorView) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.N) {
            int[] a = new int[2];
            anchorView.getLocationInWindow(a);
            showAtLocation(anchorView, Gravity.NO_GRAVITY, 0, a[1] + anchorView.getHeight() + 0);
        } else {
            super.showAsDropDown(anchorView);
        }
    }


}
