package com.lcworld.shopdemo.base;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Float.parseFloat;

public class CommonUtil {


    public static boolean isListEmpty(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static void upKeyBoard(final EditText et) {
        et.requestFocus();
        //调出键盘
        et.setFocusableInTouchMode(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

                           public void run() {
                               InputMethodManager inputManager =
                                       (InputMethodManager) et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                               inputManager.showSoftInput(et, 0);
                           }

                       },
                500);
    }


    public static String getDateTime(String date) {
        String replace = date.substring(5, 16).replace("T", " ");
        return replace;
    }

    public static String getDateTimeDetail(String date) {
        String replace = date.substring(0, 16).replace("T", " ");
        return replace;
    }

    public static String getDateTimeComment(String date) {
        String replace = date.substring(0, 19).replace("T", " ");
        return replace;
    }

    public static void hideSoftKeyboard(Activity ct) {
        InputMethodManager imm = (InputMethodManager) ct.getSystemService(Context.INPUT_METHOD_SERVICE);
        View focus = ct.getCurrentFocus();
        if (focus != null) {
            IBinder binder = focus.getWindowToken();
            if (null != binder) {
                imm.hideSoftInputFromWindow(binder, 0);
            }
        }
    }

    public static void closeSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void openSoftKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS); //显示软键盘
    }

    public static void openSoftKeyboard(View view) {
        InputMethodManager inputManager =
                (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, 0);
    }

    /**
     * 判断软键盘是否弹出
     */
    public static boolean isSHowKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        if (imm.hideSoftInputFromWindow(v.getWindowToken(), 0)) {
            imm.showSoftInput(v, 0);
            return true;
            //软键盘已弹出
        } else {
            return false;
            //软键盘未弹出
        }
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 判断当前应用程序处于前台还是后台
     */
    public static boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * s ->   小时去掉,只展示 分钟和秒
     */
    public static String formatSecond(int second) {

        Integer s = (Integer) second;

        Integer hours = (int) (s / (60 * 60));
        Integer minutes = (int) (s / 60 - hours * 60);
        Integer seconds = (int) (s - minutes * 60 - hours * 60 * 60);
        if (hours == 0) {
            if (minutes < 10 && seconds < 10)
                return "0" + minutes + ":0" + seconds;
            else if (minutes < 10 && seconds >= 10)
                return "0" + minutes + ":" + seconds;
            else if (minutes >= 10 && seconds < 10)
                return minutes + ":0" + seconds;
            else
                return minutes + ":" + seconds;
        } else {
            if (hours < 10) {
                if (minutes < 10 && seconds < 10)
                    return "0" + hours + ":0" + minutes + ":0" + seconds;
                else if (minutes < 10 && seconds >= 10)
                    return "0" + hours + ":0" + minutes + ":" + seconds;
                else if (minutes >= 10 && seconds < 10)
                    return "0" + hours + ":" + minutes + ":0" + seconds;
                else
                    return "0" + hours + ":" + minutes + ":" + seconds;
            } else {
                if (minutes < 10 && seconds < 10)
                    return hours + ":0" + minutes + ":0" + seconds;
                else if (minutes < 10 && seconds >= 10)
                    return hours + ":0" + minutes + ":" + seconds;
                else if (minutes >= 10 && seconds < 10)
                    return hours + ":" + minutes + ":0" + seconds;
                else
                    return hours + ":" + minutes + ":" + seconds;
            }

        }


    }

    //保留1位小数 float
    public static String castFloat1(String str) {
        String encStr = "";
        try {
            encStr = new DecimalFormat("0.0").format(parseFloat(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return encStr;
    }

    //保留1位小数
    public static String castDouble1(String str) {
        String encStr = "";
        try {
            encStr = new DecimalFormat("0.0").format(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return encStr;
    }

    //保留2位小数
    public static String castDouble2(String str) {
        String encStr = "";
        try {
            encStr = new DecimalFormat("0.00").format(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return encStr;
    }


    /**
     * 小数获得百分数
     *
     * @param right_per
     * @return
     */
    public static String getPerCount(String right_per) {
        String str = "";

        try {
            str = (int) (Double.parseDouble(right_per) * 100) + "%";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return str;
    }


    /**
     * IMEI 全称�?International Mobile Equipment Identity，中文翻译为国际移动装备辨识码， 即�?常所说的手机序列号，
     * 用于在手机网络中识别每一部独立的手机，是国际上公认的手机标志序号，相当于移动电话的身份证。序列号共有15位数字，�?位（TAC）是型号核准号码�?
     * 代表手机类型。接�?位（FAC）是�?��装配号，代表产地。后6位（SNR）是串号，代表生产顺序号。最�?位（SP）一般为0，是�?��码，备用�?
     * 国际移动装备辨识码一般贴于机身背面与外包装上，同时也存在于手机记忆体中，通过输入*#06#即可查询�?
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        TelephonyManager ts = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return ts.getDeviceId();
    }

    public static String getAppVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo;
        String versionCode = "";
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionCode = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    public static void controlKeyboardLayout(final View root, final View editLayout) {
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                //获取root在窗体的可视区域
                root.getWindowVisibleDisplayFrame(rect);
                //获取root在窗体的不可视区域高度(被其他View遮挡的区域高度)
                int rootInVisibleHeigh = root.getRootView().getHeight() - rect.bottom;
                //若不可视区域高度大于100，则键盘显示
                if (rootInVisibleHeigh > 100) {
                    Log.v("hjb", "不可视区域高度大于100，则键盘显示");
                    int[] location = new int[2];
                    //获取editLayout在窗体的坐标
                    editLayout.getLocationInWindow(location);
                    //计算root滚动高度，使editLayout在可见区域
                    int srollHeight = (location[1] + editLayout.getHeight()) - rect.bottom;
                    root.scrollTo(0, srollHeight);
                } else {
                    //键盘隐藏
                    Log.v("hjb", "不可视区域高度小于100，则键盘隐藏");
                    root.scrollTo(0, 0);
                }
            }
        });
    }

    public static int getRingDuring(String path) {
        MediaPlayer player = new MediaPlayer();
        try {
            player.setDataSource(path);  //recordingFilePath（）为音频文件的路径
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int duration = player.getDuration();//获取音频的时间
        Log.d("ACETEST", "### duration: " + duration);
        player.release();//记得释放资源
        return duration;
    }


    /******************** 时间相关常量 ********************/
    /**
     * 秒与毫秒的倍数
     */
    public static final int SEC = 1000;
    /**
     * 分与毫秒的倍数
     */
    public static final int MIN = 60000;
    /**
     * 时与毫秒的倍数
     */
    public static final int HOUR = 3600000;
    /**
     * 天与毫秒的倍数
     */
    public static final int DAY = 86400000;

    /**
     * 将毫秒值转换成"mmss"时间格式
     *
     * @param millis 非标准的毫秒值
     * @return
     */
    public static String millis2mmss(int millis) {
        if (millis < 0)
            return "00:00";
        int minute = millis / MIN;
        String minuteStr;
        if (minute < 10) {
            minuteStr = "0" + minute;
        } else {
            minuteStr = String.valueOf(minute);
        }

        int second = (millis - minute * MIN) / SEC;
        String secondStr;
        if (second < 10) {
            secondStr = "0" + second;
        } else {
            secondStr = String.valueOf(second);
        }
        return minuteStr + ":" + secondStr;
    }


}
