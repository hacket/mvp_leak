package com.example.zengfansheng.android_mvp;

import com.squareup.leakcanary.LeakCanary;

import android.app.Application;

/**
 * Created by zengfansheng on 2016/4/6 0006.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
