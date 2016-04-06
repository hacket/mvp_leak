package com.example.zengfansheng.android_mvp.model;

/**
 * Created by zengfansheng on 2016/4/6 0006.
 */
public interface IUserBiz {

    boolean login(User user, OnLoginListener onLoginListener);
}
