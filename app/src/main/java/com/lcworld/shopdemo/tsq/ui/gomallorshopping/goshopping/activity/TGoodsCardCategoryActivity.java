package com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.activity;


import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcworld.shopdemo.R;
import com.lcworld.shopdemo.base.BaseActivity;
import com.lcworld.shopdemo.base.BaseFrameLayout;
import com.lcworld.shopdemo.base.DensityUtils;
import com.lcworld.shopdemo.base.UIManager;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.bean.SwipeCardBean;
import com.lcworld.shopdemo.tsq.ui.gomallorshopping.goshopping.bean.TanTanCallback;
import com.mcxtzhang.commonadapter.rv.CommonAdapter;
import com.mcxtzhang.commonadapter.rv.OnItemClickListener;
import com.mcxtzhang.commonadapter.rv.ViewHolder;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 商品 卡片式分类 列表
 */
public class TGoodsCardCategoryActivity extends BaseActivity {

    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.tv1)
    TextView tv1;
    Unbinder unbinder1;
    CommonAdapter<SwipeCardBean> mAdapter;
    List<SwipeCardBean> mDatas;

    @Override
    protected int setContentView() {
        return R.layout.t_fragment_goods_card;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
        tv1.getPaint().setFakeBoldText(true);
        int flag = getIntent().getExtras().getInt("flag", 0);
        switch (flag) {
            case 0:
                tv1.setText("新款预售");
                break;
            case 1:
                tv1.setText("新款预售");
                break;
            case 2:
                tv1.setText("最新优惠");
                break;
            case 3:
                tv1.setText("联盟消费");
                break;
            case 4:
                tv1.setText("私人订制");
                break;
            default:
                break;
        }
    }

    @Override
    protected void initData() {
        mDatas = SwipeCardBean.initDatas();
        Collections.reverse(mDatas);
        mRv.setLayoutManager(new OverLayCardLayoutManager());
        mRv.setAdapter(mAdapter = new CommonAdapter<SwipeCardBean>(this, mDatas, R.layout.t_item_swipe_goodscard) {
            public static final String TAG = "zxt/Adapter";

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.d(TAG, "onCreateViewHolder() called with: parent = [" + parent + "], viewType = [" + viewType + "]");
                return super.onCreateViewHolder(parent, viewType);
            }


            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                Log.d(TAG, "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "]");
                super.onBindViewHolder(holder, position);
            }

            @Override
            public void convert(ViewHolder viewHolder, SwipeCardBean swipeCardBean) {
                CardView cardview = (CardView) viewHolder.getView(R.id.cardview);
                int height = DensityUtils.getHeight(mContext) - DensityUtils.dip2px(mContext, 160);
                cardview.setLayoutParams(new ActionMenuView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, height));
                ImageView iv = (ImageView) viewHolder.getView(R.id.iv);
                if (swipeCardBean.getPostition() == 0 || swipeCardBean.getPostition() == 3 || swipeCardBean.getPostition() == 6) {
                    iv.setImageResource(R.mipmap.xkys);
                } else if (swipeCardBean.getPostition() == 1 || swipeCardBean.getPostition() == 4 || swipeCardBean.getPostition() == 7) {
                    iv.setImageResource(R.mipmap.srdz);
                } else {
                    iv.setImageResource(R.mipmap.lmxf);
                }
            }
        });

        CardConfig.initConfig(this);

        final TanTanCallback callback = new TanTanCallback(mRv, mAdapter, mDatas);

        //测试竖直滑动是否已经不会被移除屏幕
        //callback.setHorizontalDeviation(Integer.MAX_VALUE);

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRv);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup viewGroup, View view, Object o, int i) {
                UIManager.turnToAct(TGoodsCardCategoryActivity.this, GoodsDetailActivity.class);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, Object o, int i) {
                return false;
            }
        });
    }


    @Override
    protected void setListener() {
    }

    @Override
    protected boolean setWindowDye() {
        return false;
    }

    @Override
    protected boolean setActionBarView() {
        return false;
    }


    @OnClick({R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
