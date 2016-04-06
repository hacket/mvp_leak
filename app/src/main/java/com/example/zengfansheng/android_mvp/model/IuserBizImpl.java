package com.example.zengfansheng.android_mvp.model;

import android.os.SystemClock;

/**
 * Created by zengfansheng on 2016/4/6 0006.
 */
public class IuserBizImpl implements IUserBiz {

    @Override
    public boolean login(final User user, final OnLoginListener onLoginListener) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                SystemClock.sleep(5000);

                if ("hacket".equals(user.username) && "123456".equals(user.pwd)) {
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFailed(user, "error user or pwd!");
                }
            }
        }.start();
        return false;
    }

}