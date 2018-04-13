package com.lcworld.shopdemo.rmq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.DensityUtils;
import com.lcworld.shopdemo.base.SettingBean;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 分组 编辑好友 single
 */
public class GvSettingAdapter extends MyBaseAdapter<SettingBean> {
    private Context mContext;
    private LayoutInflater mInflater;

    public GvSettingAdapter(Context context) {
        super(context);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gv_item_setting, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SettingBean bean = getItemList().get(position);
        holder.tvName.setText(bean.name);
        holder.ivImage.setImageResource(bean.image);
        //设置

        holder.llLayout.setLayoutParams(new LinearLayout.LayoutParams(DensityUtils.getWidth(mContext) / 3, DensityUtils.getWidth(mContext) / 3));
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.iv_image)
        ImageView ivImage;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.ll_layout)
        LinearLayout llLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
