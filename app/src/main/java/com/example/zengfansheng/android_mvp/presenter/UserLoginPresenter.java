package com.example.zengfansheng.android_mvp.presenter;

import com.example.zengfansheng.android_mvp.base.BasePresenter;
import com.example.zengfansheng.android_mvp.model.IUserBiz;
import com.example.zengfansheng.android_mvp.model.IuserBizImpl;
import com.example.zengfansheng.android_mvp.model.OnLoginListener;
import com.example.zengfansheng.android_mvp.model.User;
import com.example.zengfansheng.android_mvp.view.ILoginView;

import android.os.Handler;

/**
 * Created by zengfansheng on 2016/4/6 0006.
 */
public class UserLoginPresenter extends BasePresenter<ILoginView> {

    private IUserBiz mUserBiz;
    private ILoginView mLoginView;

    private Handler mHandler = new Handler();

    public UserLoginPresenter(ILoginView loginView) {
        this.mLoginView = loginView;
        mUserBiz = new IuserBizImpl();
    }

    public void login() {
        mLoginView.showLoading();

        String username = mLoginView.getUsername();
        String pwd = mLoginView.getPwd();
        mUserBiz.login(new User(username, pwd), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showLoginSuccess(user);
                        mLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed(final User user, final String errorMsg) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.showLoginFailed(user, errorMsg);
                        mLoginView.hideLoading();
                    }
                });
            }
        });
    }

}