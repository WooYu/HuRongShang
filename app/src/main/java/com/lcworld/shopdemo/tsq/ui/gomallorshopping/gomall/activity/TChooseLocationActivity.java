//package com.lcworld.shopdemo.tsq.ui.gomallorshopping.gomall.activity;
//
//
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.baidu.mapapi.model.LatLng;
//import com.baidu.mapapi.search.core.PoiInfo;
//import com.baidu.mapapi.search.geocode.GeoCodeResult;
//import com.baidu.mapapi.search.geocode.GeoCoder;
//import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
//import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
//import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
//import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
//import com.baidu.mapapi.search.sug.SuggestionResult;
//import com.baidu.mapapi.search.sug.SuggestionSearch;
//import com.baidu.mapapi.search.sug.SuggestionSearchOption;
//import com.duke.base.util.CommonUtil;
//import com.duke.base.util.LocationUtils;
//import com.duke.base.util.LogUtil;
//import com.duke.circle.R;
//import com.duke.circle.framework.base.BaseActivity;
//import com.duke.circle.framework.base.BaseFrameLayout;
//import com.duke.circle.ui.communication.adapter.LocationPoiAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import butterknife.Unbinder;
//
///**
// * 拓商圈-切换位置
// */
//public class TChooseLocationActivity extends BaseActivity implements AdapterView.OnItemClickListener, OnGetGeoCoderResultListener, OnGetSuggestionResultListener {
//
//    @BindView(R.id.ll_back)
//    LinearLayout llBack;
//    @BindView(R.id.title_name)
//    TextView titleName;
//    @BindView(R.id.tv_search)
//    AutoCompleteTextView keyWorldsView;
//    @BindView(R.id.ll_search_click)
//    LinearLayout llSearchClick;
//    @BindView(R.id.ll_location)
//    LinearLayout llLocation;
//    @BindView(R.id.lv_address_search_activity)
//    ListView listView;
//    private ArrayList<PoiInfo> datas;
//    private Unbinder unbinder;
//    private LocationUtils utils;
//    private LocationPoiAdapter adapter;
//    private SuggestionSearch mSuggestionSearch;
//    private ArrayAdapter<String> sugAdapter;
//    private List<SuggestionResult.SuggestionInfo> allSuggestionsList;//搜索到的信息
//    private GeoCoder mSearch;
//    private List<String> suggest;
//
//    //    AddressSearchActivity
//    @Override
//    protected int setContentView() {
//        return R.layout.t_act_chooseloction;
//    }
//
//    @Override
//    protected void initView() {
//        unbinder = ButterKnife.bind(this);
//        baseFrameLayout.setState(BaseFrameLayout.STATE_SUCCESS);
//        datas = new ArrayList<>();
//
//        adapter = new LocationPoiAdapter(this, datas);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);
//        //搜索位置
//        mSearch = GeoCoder.newInstance();
//        mSearch.setOnGetGeoCodeResultListener(this);
//        // 初始化建议搜索模块，注册建议搜索事件监听
//        mSuggestionSearch = SuggestionSearch.newInstance();
//        mSuggestionSearch.setOnGetSuggestionResultListener(this);
//
//        sugAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line);
//        keyWorldsView.setAdapter(sugAdapter);
//        keyWorldsView.setThreshold(1);
//
//        /**
//         * 当输入关键字变化时，动态更新建议列表
//         */
//        keyWorldsView.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void afterTextChanged(Editable arg0) {
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1,
//                                          int arg2, int arg3) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence cs, int arg1, int arg2,
//                                      int arg3) {
//                if (cs.length() <= 0) {
//                    return;
//                }
//
//                /**
//                 * 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
//                 */
//                mSuggestionSearch
//                        .requestSuggestion((new SuggestionSearchOption())
//                                .keyword(cs.toString()).city(""));
//            }
//        });
//        //选择搜索结果
//        keyWorldsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                LatLng latLng = allSuggestionsList.get(position).pt;
//                mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
//                CommonUtil.hideSoftKeyboard(TChooseLocationActivity.this);
//            }
//        });
//    }
//
//
//    @Override
//    protected void initData() {
//        setLocation();
//    }
//
//    private void setLocation() {
//        utils = new LocationUtils(this);
//        utils.setNeedAddress(true);
//        utils.setRefreshLocationListener(new LocationUtils.OnRefreshLocationListener() {
//            @Override
//            public void locationListener(double longitude, double latitude) {
//                LatLng ll = new LatLng(latitude, longitude);
//                mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(ll));
//            }
//        });
//        utils.startLocation();
//    }
//
//    @Override
//    protected void setListener() {
//
//    }
//
//    @OnClick({R.id.ll_back, R.id.ll_location})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.ll_back:
//                finish();
//                break;
//            case R.id.ll_location:
//                setLocation();
//                break;
//        }
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
//    @Override
//    public void onDestroy() {
//        mSuggestionSearch.destroy();
//        super.onDestroy();
//        unbinder.unbind();
//    }
//
//    /**
//     * Callback method to be invoked when an item in this AdapterView has
//     * been clicked.
//     * <p>
//     * Implementers can call getItemAtPosition(position) if they need
//     * to access the data associated with the selected item.
//     *
//     * @param parent   The AdapterView where the click happened.
//     * @param view     The view within the AdapterView that was clicked (this
//     *                 will be a view provided by the adapter)
//     * @param position The position of the view in the adapter.
//     * @param id       The row id of the item that was clicked.
//     */
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//
//    @Override
//    public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
//
//    }
//
//    @Override
//    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
//        //获取地图周边信息
//        datas.clear();
//        if (reverseGeoCodeResult != null && !CommonUtil.isListEmpty(reverseGeoCodeResult.getPoiList())) {
//
//            for (PoiInfo i : reverseGeoCodeResult.getPoiList()) {
//                LogUtil.i(i.address);
//                datas.add(i);
//            }
////            poiInfo = datas.get(0);
//        }
//        adapter.notifyDataSetChanged();
//
//    }
//
//    /**
//     * 在线搜索
//     *
//     * @param res
//     */
//    @Override
//    public void onGetSuggestionResult(SuggestionResult res) {
//        if (res == null || res.getAllSuggestions() == null) {
//            return;
//        }
//        suggest = new ArrayList<String>();
//        allSuggestionsList = res.getAllSuggestions();
//        for (SuggestionResult.SuggestionInfo info : res.getAllSuggestions()) {
//            if (info.key != null) {
//                LogUtil.d("direction:" + info.district);
//                suggest.add(info.key);
//            }
//        }
//        sugAdapter = new ArrayAdapter<String>(TChooseLocationActivity.this, android.R.layout.simple_dropdown_item_1line, suggest);
//        keyWorldsView.setAdapter(sugAdapter);
//        sugAdapter.notifyDataSetChanged();
//    }
//}
