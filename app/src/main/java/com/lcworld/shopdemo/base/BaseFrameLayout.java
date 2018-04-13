package com.lcworld.shopdemo.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lcworld.shopdemo.R;


/**
 * 创建：duke
 * 日期： 2016/8/9
 * 注释：基类布局 根布局
 * 加载中
 * 加载错误
 * 加载失败
 * 加载成功
 */
public abstract class BaseFrameLayout extends RelativeLayout {
    /*
     *   页面加载中
     */
    public static final int STATE_LOADING = 0;
    /*
     *   页面加载错误
     */
    public static final int STATE_ERROR = 1;
    /*
     *   页面加载数据为空
     */
    public static final int STATE_EMPTY = 2;
    /*
     *   页面加载成功
     */
    public static final int STATE_SUCCESS = 3;

    private int state = STATE_LOADING;

    private View loadingView, errView, emptyView, successView, actionbarView;
    /**
     * 显示自定义view
     */
    private View customEmptyView;

    private Context context;
    private ProgressWheel lvBlock;

    private OnAnewLoadListener listener;
    private OnEmptyLoadListener emptyLoadListener;

    public void setEmptyLoadListener(OnEmptyLoadListener emptyLoadListener) {
        this.emptyLoadListener = emptyLoadListener;
    }

    public void setListener(OnAnewLoadListener listener) {
        this.listener = listener;
    }

    public BaseFrameLayout(Context context) {
        this(context, null);
    }

    public BaseFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
//        if (setTitleBarView())
//            setFitsSystemWindows(true);
        setFitsSystemWindows(true);
        init();
    }

    private void init() {
        if (successView == null) {
            successView = LayoutInflater.from(context).inflate(setContentView(), null);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (setActionBarView() && actionbarView == null) {
                actionbarView = successView.findViewById(R.id.actionbar);
                ((ViewGroup) successView).removeView(actionbarView);
                this.addView(actionbarView);
                params.addRule(BELOW, R.id.actionbar);
            }
            this.addView(successView, params);
        }

        if (loadingView == null) {
            loadingView = LayoutInflater.from(context).inflate(R.layout.base_loading_layout, null);
            lvBlock = (ProgressWheel) loadingView.findViewById(R.id.load);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (setActionBarView())
                params.addRule(BELOW, R.id.actionbar);
            this.addView(loadingView, params);
        }
        if (errView == null) {
            errView = LayoutInflater.from(context).inflate(R.layout.base_err_layout, null);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (setActionBarView())
                params.addRule(BELOW, R.id.actionbar);
            this.addView(errView, params);
        }

        if (emptyView == null) {
            emptyView = LayoutInflater.from(context).inflate(R.layout.base_empity_layout, null);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (setActionBarView())
                params.addRule(BELOW, R.id.actionbar);
            this.addView(emptyView, params);
        }
        showView(state);
    }

    private void showView(int state) {
        this.state = state;
        if (loadingView != null) {
            if (state == STATE_LOADING) {
                loadingView.setVisibility(VISIBLE);
            } else {
                loadingView.setVisibility(INVISIBLE);
            }
        }
        if (errView != null) {
            errView.setVisibility(state == STATE_ERROR ? VISIBLE : INVISIBLE);
            errView.findViewById(R.id.load_layout).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    setState(STATE_LOADING);
                    if (listener != null) {
                        listener.onAnewLoadListener();
                    }
                }
            });
        }
        if (customEmptyView != null) {
            customEmptyView.setVisibility(state == STATE_EMPTY ? VISIBLE : INVISIBLE);
        } else if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? VISIBLE : INVISIBLE);
            emptyView.findViewById(R.id.empity_text).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (emptyLoadListener != null) {
                        setState(STATE_LOADING);
                        emptyLoadListener.onEmptyLoadListener();
                    }
                }
            });
        }
        if (successView != null) {
            successView.setVisibility(state == STATE_SUCCESS ? VISIBLE : INVISIBLE);
        }
    }

    public void setState(int state) {
        showView(state);
    }

    /**
     * setContentView
     */
    protected abstract int setContentView();

    /**
     * 是否有标题栏
     * setActionBarView
     */
    protected abstract boolean setActionBarView();

    /**
     * 是否有状态栏title
     * setTitleBarView
     */
    protected abstract boolean setTitleBarView();



    /**
     * 提供 加载失败时 重新加载 接口
     */
    public interface OnAnewLoadListener {
        void onAnewLoadListener();
    }

    /**
     * 提供 加载数据为空时 重新加载 接口
     */
    public interface OnEmptyLoadListener {
        void onEmptyLoadListener();
    }


    public void setCustomEmptyView(int resId) {
        customEmptyView = LayoutInflater.from(context).inflate(resId, null);
        customEmptyView.setVisibility(INVISIBLE);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (setActionBarView())
            params.addRule(BELOW, R.id.actionbar);
        this.addView(customEmptyView, params);
    }

    public void setCustomEmptyView(View view) {
        customEmptyView = view;
        customEmptyView.setVisibility(INVISIBLE);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (setActionBarView())
            params.addRule(BELOW, R.id.actionbar);
        this.addView(customEmptyView, params);
    }
}
