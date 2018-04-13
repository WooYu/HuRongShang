package com.lcworld.shopdemo.base;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcworld.shopdemo.R;


/**
 * 创建：dongxiaoshuai
 * 自定义actionbar
 */
public class Actionbar extends RelativeLayout {
    private RelativeLayout leftLayout, rightLayout;
    private ImageView rightBtn, leftBtn;
    private TextView rightText, leftText, titleText;
    private int defaultBackgroundColor = getResources().getColor(R.color.white);
    private int rightTextColor = getResources().getColor(R.color.actionbar_color);
    private int leftTextColor = getResources().getColor(R.color.actionbar_color);
    private int titleTextColor = getResources().getColor(R.color.actionbar_color);
    private float rightTextSize;
    private float leftTextSize;
    private float titleTextSize;
    private String rightTxt, leftTxt, titleTxt;
    private Drawable rightBackground, leftBackground;
    private ActionbarOnClickListener listener;
    private ActionBarOnClickListener_title titleListener;
    private ActionBarOnLongClickListener longClickListener;
    private RelativeLayout line;

    public void setListener(ActionbarOnClickListener listener) {
        this.listener = listener;
    }

    public void setTitleClick(ActionBarOnClickListener_title titleListener) {
        this.titleListener = titleListener;
    }

    public void setLongClick(ActionBarOnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public Actionbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(defaultBackgroundColor);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Actionbar);

        titleTxt = typedArray.getString(R.styleable.Actionbar_titleText);
        titleTextSize = typedArray.getDimension(R.styleable.Actionbar_titleTextSize, -1);
        titleTextColor = typedArray.getColor(R.styleable.Actionbar_mTitleTextColor, this.titleTextColor);

        rightTxt = typedArray.getString(R.styleable.Actionbar_rightText);
        rightTextSize = typedArray.getDimension(R.styleable.Actionbar_rightTextSize, -1);
        rightTextColor = typedArray.getColor(R.styleable.Actionbar_rightTextColor, this.rightTextColor);

        leftTxt = typedArray.getString(R.styleable.Actionbar_leftText);
        leftTextSize = typedArray.getDimension(R.styleable.Actionbar_leftTextSize, -1);
        leftTextColor = typedArray.getColor(R.styleable.Actionbar_leftTextColor, this.leftTextColor);

        leftBackground = typedArray.getDrawable(R.styleable.Actionbar_leftBackground);
        rightBackground = typedArray.getDrawable(R.styleable.Actionbar_rightBackground);
        typedArray.recycle();

        if (leftTextSize < 0) {
            leftTextSize = DisplayUtil.sp2px(context, 16);
        }
        if (rightTextSize < 0) {
            rightTextSize = DisplayUtil.sp2px(context, 16);
        }
        if (titleTextSize < 0) {
            titleTextSize = DisplayUtil.sp2px(context, 18);
        }

        if (titleTxt != null) {
            titleText = new TextView(context);
            titleText.setText(titleTxt);
            titleText.setTextSize(DisplayUtil.px2sp(context, titleTextSize));
            titleText.setTextColor(titleTextColor);
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(CENTER_IN_PARENT);
            titleText.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (titleListener != null)
                        titleListener.OnClickListener_title();
                }
            });
            addView(titleText, layoutParams);
        }


        leftText = new TextView(context);
        leftText.setTextSize(DisplayUtil.px2sp(context, leftTextSize));
        leftText.setTextColor(leftTextColor);
        LayoutParams leftTextParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftTextParams.addRule(ALIGN_PARENT_LEFT);
        leftTextParams.addRule(CENTER_VERTICAL);
        leftText.setPadding(DisplayUtil.dip2px(context, 12), 0, DisplayUtil.dip2px(context, 12), 0);
        addView(leftText, leftTextParams);

        leftText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.leftOnClickListener(leftText);
                }
            }
        });
        if (leftTxt != null) {
            leftText.setVisibility(VISIBLE);
            leftText.setText(leftTxt);
        } else {
            leftText.setVisibility(GONE);
        }


        leftBtn = new ImageView(context);
        LayoutParams leftBtnParams = new LayoutParams(DisplayUtil.dip2px(context, 20), DisplayUtil.dip2px(context, 20));
        leftBtnParams.addRule(ALIGN_PARENT_LEFT);
        leftBtnParams.addRule(CENTER_VERTICAL);
        leftBtnParams.leftMargin = DisplayUtil.dip2px(context, 12);
        leftLayout = new RelativeLayout(context);
        leftLayout.addView(leftBtn, leftBtnParams);
        LayoutParams leftLayoutParams = new LayoutParams(DisplayUtil.dip2px(context, 48), DisplayUtil.dip2px(context, 48));
        leftLayoutParams.addRule(ALIGN_PARENT_LEFT);
        addView(leftLayout, leftLayoutParams);

        leftLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.leftOnClickListener(v);
            }
        });

        if (leftBackground != null) {
            leftLayout.setVisibility(VISIBLE);
            leftBtn.setBackground(leftBackground);
        } else {
            leftLayout.setVisibility(GONE);
        }


        rightText = new TextView(context);
        rightText.setTextSize(DisplayUtil.px2sp(context, rightTextSize));
        rightText.setTextColor(rightTextColor);
        LayoutParams rightTextParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightTextParams.addRule(ALIGN_PARENT_RIGHT);
        rightTextParams.addRule(CENTER_VERTICAL);
        rightText.setGravity(Gravity.CENTER);
        rightText.setPadding(DisplayUtil.dip2px(context, 12), 0, DisplayUtil.dip2px(context, 12), 0);
        addView(rightText, rightTextParams);

        rightText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.rightOnClickListener(v);
                }
            }
        });


        if (rightTxt != null) {
            rightText.setVisibility(VISIBLE);
            rightText.setText(rightTxt);
        } else {
            rightText.setVisibility(GONE);
        }


        rightBtn = new ImageView(context);
        LayoutParams rightBtnParams = new LayoutParams(DisplayUtil.dip2px(context, 20), DisplayUtil.dip2px(context, 20));
        rightBtnParams.addRule(CENTER_VERTICAL);
        rightBtnParams.addRule(ALIGN_PARENT_RIGHT);
        rightBtnParams.rightMargin = DisplayUtil.dip2px(context, 12);
        rightLayout = new RelativeLayout(context);
        rightLayout.addView(rightBtn, rightBtnParams);
        LayoutParams rightLayoutParams = new LayoutParams(DisplayUtil.dip2px(context, 48), DisplayUtil.dip2px(context, 48));
        rightLayoutParams.addRule(ALIGN_PARENT_RIGHT);
        addView(rightLayout, rightLayoutParams);

        rightLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.rightOnClickListener(v);
            }
        });

        rightLayout.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (longClickListener != null) {
                    longClickListener.setOnLongClickListener(view);
                }
                return true;
            }
        });
        if (rightBackground != null) {
            rightLayout.setVisibility(VISIBLE);
            rightBtn.setBackground(rightBackground);
        } else {
            rightLayout.setVisibility(GONE);
        }

        //底部下划线
        line = new RelativeLayout(context);
        line.setBackgroundColor(getResources().getColor(R.color.line_color));
        LayoutParams lineParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.dip2px(context, 0.5f));
        lineParams.addRule(ALIGN_PARENT_BOTTOM);
        addView(line, lineParams);
    }

    public void hideLine() {
        line.setVisibility(GONE);
    }

    public void setTitleTxt(String titleTxt) {
        titleText.setText(titleTxt);
    }

    public void setLeftTxt(String leftTxt) {
        if (leftLayout != null && leftLayout.getVisibility() == VISIBLE) {
            leftLayout.setVisibility(GONE);
        }
        leftText.setVisibility(VISIBLE);
        leftText.setText(leftTxt);
    }

    public void setRightTxt(String rightTxt) {
        if (rightLayout != null && rightLayout.getVisibility() == VISIBLE) {
            rightLayout.setVisibility(GONE);
        }
        if (TextUtils.isEmpty(rightTxt)) {
            rightText.setText(rightTxt);
            rightText.setVisibility(GONE);
        } else {
            rightText.setVisibility(VISIBLE);
            rightText.setText(rightTxt);
        }

    }

    //获得右边的TextView内容
    public String getRightTxt() {
        return rightText.getText().toString().trim();
    }

    public void setRightBackground(int i) {
        if (rightText != null && rightText.getVisibility() == VISIBLE) {
            rightText.setVisibility(GONE);
        }
        rightLayout.setVisibility(VISIBLE);
        rightBtn.setBackgroundResource(i);
    }

    public void setRightBackgroundShow(boolean isShow) {
        if (rightText != null && rightText.getVisibility() == VISIBLE) {
            rightText.setVisibility(GONE);
        }
        rightLayout.setVisibility(isShow ? VISIBLE : GONE);
    }

    public void setLeftBackground(int i) {
        if (leftText != null && leftText.getVisibility() == VISIBLE) {
            leftText.setVisibility(GONE);
        }
        leftLayout.setVisibility(VISIBLE);
        leftBtn.setBackgroundResource(i);
    }

    public interface ActionbarOnClickListener {
        void rightOnClickListener(View v);

        void leftOnClickListener(View v);
    }

    public interface ActionBarOnLongClickListener {
        void setOnLongClickListener(View view);
    }

    public interface ActionBarOnClickListener_title {
        void OnClickListener_title();
    }
}
