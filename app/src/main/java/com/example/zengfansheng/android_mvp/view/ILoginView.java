package com.example.zengfansheng.android_mvp.view;

import com.example.zengfansheng.android_mvp.model.User;

/**
 * Created by zengfansheng on 2016/4/6 0006.
 */
public interface ILoginView {

    void showLoading();

    void hideLoading();

    void showLoginSuccess(User user);

    void showLoginFailed(User user, String errorMsg);

    String getUsername();

    String getPwd();

    //    void clearUsername();
    //
    //    void clearPwd();

}
