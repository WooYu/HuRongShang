package com.lcworld.shopdemo.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.lcworld.shopdemo.base.application.CCApplication;

import java.util.ArrayList;
import java.util.List;


/*
 * dongshuaijun
 * app native data
 */
public class AppConfig {
    private static final String TAG = "AppConfig";
    private static final boolean D = false;
    private static AppConfig mySelf = null;
    private static final String NEARBY = "nearby";
    SharedPreferences preferences = null;
    public static final String PREFERENCES_FILE_NAME = "Preferences";
    public static final String KEY_PASSWORD = "password";
    public static final String QR_PASSWORD = "qr_password";
    public static final String USER_ID = "userId";
    public static final String KEY_USER = "user";
    public static final String TIMEBEAN = "timeBean";
    public static final String KEY_USER_SETTING = "user_setting";

    public static final String AUTO_LINK_LONG_CLICK = "AUTO_LINK_LONG_CLICK";//
    public static final String KEEP_PASSWORD = "keep_password";//记住密码
    public static final String IS_SPECIAL = "IS_SPECIAL";//

    //是否登录
    public static final String IS_LOGIN = "isLogin";
    //是否是第三方登入
    public static final String IS_THIRD_LOGIN = "isThirdLogin";
    //第一次启动应用
    public static final String IS_FIRST = "isFirst";
    //当前版本号
    public static final String CURR_VERSION = "CurrVersion";


    public static AppConfig getInstance() {
        if (mySelf == null) {
            mySelf = new AppConfig();
        }
        return mySelf;
    }

    private AppConfig() {
        try {
            preferences = CCApplication.app.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        } catch (Exception ex) {
            if (D) {
                Log.e(TAG, ex.getMessage());
            }
        }
    }

    public void preferencesSetString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private void preferenceDelete(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }

    private void preferencesSetInt(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private void preferencesSetBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private int preferencesGetInt(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }

    public String preferencesGetString(String key, String defValue) {
        return preferences.getString(key, defValue);
    }

    private boolean preferencesGetBoolean(String key, boolean defValue) {
        return preferences.getBoolean(key, defValue);
    }


    public void setUserId(String userId) {
        preferencesSetString(USER_ID, userId);
    }

    public String getUserId() {
        return preferencesGetString(USER_ID, "");
    }

    //   //0特小 1小 2标准 3超大 4特大
    public void setFontSize(int FontSize) {
        preferencesSetInt("FontSize", FontSize);
    }

    public int getFontSize() {
        return preferencesGetInt("FontSize", 2);
    }

    //    设置本地一键呼叫消息数
    public void setYJHJ_COUNT(int yjhj_count) {
        preferencesSetInt("YJHJ_COUNT" + getUserId(), yjhj_count);
    }

    public int getYJHJ_COUNT() {
        return preferencesGetInt("YJHJ_COUNT" + getUserId(), 0);
    }

    public void setLastTime(String date) {
        preferencesSetString("LastTime" + getUserId(), date);
    }

    public String getLastTime() {
        return preferencesGetString("LastTime" + getUserId(), "");
    }

    //主页请求接口
    public void setLastTime_main_remind(String type, String date) {
        preferencesSetString("LastTime_main_" + getInstance().getUserId() + "_" + type, date);
    }

    public String getLastTime_main_remind(String type) {
        return preferencesGetString("LastTime_main_" + getInstance().getUserId() + "_" + type, "");
    }

    //存登录手机号
    public void setLoginMobile(String userId) {
        preferencesSetString("LoginMobile", userId);
    }

    public String getLoginMobile() {
        return preferencesGetString("LoginMobile", "");
    }


    public void setToken(String token) {
        preferencesSetString("token", token);
    }

    public String getToken() {
        return preferencesGetString("token", "");
    }


    public boolean getIsFirst() {
        return preferencesGetBoolean(IS_FIRST, true);
    }

    public void setIsFirst(boolean b) {
        preferencesSetBoolean(IS_FIRST, b);
    }


    public int getCurrVersion() {
        return preferencesGetInt(CURR_VERSION, -1);
    }

    public void setCurrVersion(int version) {
        preferencesSetInt(CURR_VERSION, version);
    }

    public void setIsLogin(boolean b) {
        preferencesSetBoolean(IS_LOGIN, b);
    }

    public boolean getIsLogin() {
        return preferencesGetBoolean(IS_LOGIN, false);
    }

    public void setAutoLinkIsLongClick(boolean b) {
        preferencesSetBoolean(AUTO_LINK_LONG_CLICK, b);
    }

    public boolean getAutoLinkIsLongClick() {
        return preferencesGetBoolean(AUTO_LINK_LONG_CLICK, false);
    }

    public void setNearbyRemind(boolean b) {
        preferencesSetBoolean(NEARBY, b);
    }

    public boolean getNearbyRemind() {
        return preferencesGetBoolean(NEARBY, false);
    }


    public void setKeepPassword(boolean b) {
        preferencesSetBoolean(KEEP_PASSWORD, b);
    }

    public boolean getKeepPassword() {
        return preferencesGetBoolean(KEEP_PASSWORD, false);
    }

    //是否是个性版 默认false
    public void setIsSpecial(boolean b) {
        preferencesSetBoolean(IS_SPECIAL, b);
    }

    public boolean getIsSpecial() {
        return preferencesGetBoolean(IS_SPECIAL, true);
    }


    //通讯录电话薄start
    public void setTelephoneBookBeanJson(String json) {
        preferences.edit().putString("TelephoneBookBean", json).commit();
    }

    public String getTelephoneBookBeanJsonStr() {
        return preferences.getString("TelephoneBookBean", "");
    }


    /**
     * 设置消息end毫秒值
     *
     * @param Millis 毫秒值
     */
    public void setMessageEndTime(String msdId, long Millis) {
        preferences.edit().putLong("msdId_" + msdId, Millis).commit();
    }

    public long getMessageEndTime(String msdId) {
        return preferences.getLong("msdId_" + msdId, -1);
    }

    //

    /**
     * 密聊消息是否已读
     *
     * @param b
     */
    public void setSectretMessageHasRead(String msdId, boolean b) {
        preferencesSetBoolean("SectretMessageHasRead_" + msdId, b);
    }

    public boolean getSectretMessageHasRead(String msdId) {
        return preferencesGetBoolean("SectretMessageHasRead_" + msdId, false);
    }

    /**
     * 群聊创建会话列表 小于3s不刷新
     *
     * @param Millis 毫秒值
     */
    public void setConversationRefreshTime(long Millis) {
        preferences.edit().putLong("Millis_conversation_refresh", Millis).commit();
    }

    public long getConversationRefreshTime() {
        return preferences.getLong("Millis_conversation_refresh", 0l);
    }

    /**
     * 好友申请毫秒值 小于3s不提示
     *
     * @param Millis 毫秒值
     */
    public void setFriendApplyTime(long Millis) {
        preferences.edit().putLong("Millis_friend_apply", Millis).commit();
    }

    public long getFriendApplyTime() {
        return preferences.getLong("Millis_friend_apply", 0l);
    }

    /**
     * 好友申请毫秒值 小于3s不提示
     *
     * @param Millis 毫秒值
     */
    public void setFriendAgreeTime(long Millis) {
        preferences.edit().putLong("Millis_friend_agree", Millis).commit();
    }

    public long getFriendAgreeTime() {
        return preferences.getLong("Millis_friend_agree", 0l);
    }

    /**
     * 被好友删除 毫秒值 小于3s不做操作
     *
     * @param Millis 毫秒值
     */
    public void setFriendDeleteTime(long Millis) {
        preferences.edit().putLong("Millis_friend_delete", Millis).commit();
    }

    public long getFriendDeleteTime() {
        return preferences.getLong("Millis_friend_delete", 0l);
    }

    /**
     * 会话失效3s不操作
     *
     * @param Millis 毫秒值
     */
    public void setLogoutTime(long Millis) {
        preferences.edit().putLong("Millis_logout_time", Millis).commit();
    }

    public long getLogoutTime() {
        return preferences.getLong("Millis_logout_time", 0l);
    }

    //投诉投诉类型0：用户 1：群组 2：人脉圈
    public void setComplainType(int complainType) {
        preferencesSetInt("complainType", complainType);
    }

    public int getComplainType() {
        return preferencesGetInt("complainType", -1);
    }

    //投诉
    public void setHxPwd(String pwd) {
        preferencesSetString("hx_pwd", pwd);
    }

    public String getHxPwd() {
        return preferencesGetString("hx_pwd", "");
    }

    //切换主要版本 -- 默认是0人脉聊天  1拓商圈   2社团圈   3移动办公
    public void setMainType(int mainType) {
        preferencesSetInt("mainType", mainType);
    }

    public int getMainType() {
        return preferencesGetInt("mainType", 0);
    }




    /*-----------------------2018新增---------------------------*/

    /**
     * 保存定位的经度
     */
    public void saveLatitude(double latitude) {
        preferencesSetString("LATITUDE", latitude + "");
    }

    /**
     * 获取定位的经度
     */
    public double getLatitude() {
        String latitude = preferencesGetString("LATITUDE", "");
        if (TextUtils.isEmpty(latitude)) {
            return 0;
        }
        return Double.parseDouble(latitude);
    }

    /**
     * 保存定位的城市
     */
    public void saveCity(String address) {
        preferencesSetString("CITY", address);
    }

    /**
     * 获取定位的经度
     */
    public String getCity() {
        String city = preferencesGetString("CITY", "");
        if (TextUtils.isEmpty(city)) {
            return "";
        }
        return city;
    }

    /**
     * 保存定位的纬度
     */
    public void saveLongitude(double longitude) {
        preferencesSetString("LONGITUDE", longitude + "");
    }

    /**
     * 获取定位的纬度
     */
    public double getLongitude() {
        String longitude = preferencesGetString("LONGITUDE", "");
        if (TextUtils.isEmpty(longitude)) {
            return 0;
        }
        return Double.parseDouble(longitude);
    }
}