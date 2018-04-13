package com.lcworld.shopdemo.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by xinshuai on 2018/1/24.
 */

public class BaseFragment_base extends Fragment {

    /**
     * 短时间显示Toast
     *
     * @param info 显示的内容
     */
    public void showToast(String info) {
        Toast.makeText(getActivity(), info, Toast.LENGTH_SHORT).show();
    }
}
