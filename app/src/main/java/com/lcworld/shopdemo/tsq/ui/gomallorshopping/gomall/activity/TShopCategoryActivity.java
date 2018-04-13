//package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.activity;
//
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import com.duke.base.util.UIManager;
//import com.duke.base.widget.NoSlidingListView;
//import com.duke.base.widget.actionbar.Actionbar;
//import com.duke.circle.R;
//import com.duke.circle.framework.base.BaseActivity;
//import com.duke.circle.framework.base.BaseFrameLayout;
//import com.duke.tsq.ui.main.adapter.MarketOrShopListAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
//import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
//
///**
// * 分类 ——商铺列表
// */
//public class TShopCategoryActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {
//
//
//    @BindView(R.id.actionbar)
//    Actionbar actionbar;
//    @BindView(R.id.tv_location)
//    TextView tvLocation;
//    @BindView(R.id.listview)
//    NoSlidingListView listview;
//    @BindView(R.id.bga_refresh)
//    BGARefreshLayout bgaRefresh;
//    private List<String> mList;
//    private MarketOrShopListAdapter adapter;
//
//    @Override
//    protected int setContentView() {
//        return R.layout.t_act_shopcategory;
//    }
//
//    @Override
//    protected void initView() {
//        ButterKnife.bind(this);
//        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
//        bgaRefresh.setDelegate(this);
//        bgaRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(this, true));
//        //标题
//        actionbar.setBackgroundResource(R.color.theme_tsq);
//        actionbar.setListener(new Actionbar.ActionbarOnClickListener() {
//            @Override
//            public void rightOnClickListener(View v) {
//            }
//
//            @Override
//            public void leftOnClickListener(View v) {
//                finish();
//            }
//        });
//
//    }
//
//    @Override
//    protected void initData() {
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            String name = bundle.getString("name");
//            actionbar.setTitleTxt(name);
//        }
//        mList = new ArrayList<>();
//        adapter = new MarketOrShopListAdapter<>(this, mList);
//        listview.setAdapter(adapter);
//        getData();
//    }
//
//    @Override
//    protected void setListener() {
//    }
//
//    @Override
//    protected boolean setWindowDye() {
//        return false;
//    }
//
//    @Override
//    protected boolean setActionBarView() {
//        return false;
//    }
//
//    @OnClick({R.id.ll_location})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.ll_location:
//                UIManager.turnToAct(this, TChooseLocationActivity.class);
//                break;
//        }
//    }
//
//
//    public void getData() {
//        for (int i = 0; i < 10; i++) {
//            mList.add("测试");
//        }
//        adapter.notifyDataSetChanged();
//    }
//
//
//    /**
//     * 开始刷新
//     *
//     * @param refreshLayout
//     */
//    @Override
//    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
//        bgaRefresh.endRefreshing();
//    }
//
//    /**
//     * 开始加载更多。由于监听了ScrollView、RecyclerView、AbsListView滚动到底部的事件，所以这里采用返回boolean来处理是否加载更多。否则使用endLoadingMore方法会失效
//     *
//     * @param refreshLayout
//     * @return 如果要开始加载更多则返回true，否则返回false。（返回false的场景：没有网络、一共只有x页数据并且已经加载了x页数据了）
//     */
//    @Override
//    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
//        return false;
//    }
//}
