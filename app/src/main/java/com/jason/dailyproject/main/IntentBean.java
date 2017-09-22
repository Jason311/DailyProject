package com.jason.dailyproject.main;

import android.app.Activity;

/**
 * 创建日期: 2017/9/21 on 下午9:32
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class IntentBean {

    private Activity activity;
    private String demoName;

    public IntentBean(Activity activity, String demoName) {
        this.activity = activity;
        this.demoName = demoName;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }
}
