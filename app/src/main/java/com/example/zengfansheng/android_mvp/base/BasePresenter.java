package com.example.zengfansheng.android_mvp.base;

import java.lang.ref.WeakReference;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * MVP公共的BasePresenter
 * <p/>
 * TV： View对应的接口
 * <p/>
 * Created by zengfansheng on 2016/4/6 0006.
 */
public class BasePresenter<V> {

    private WeakReference<V> mWeakRefView;

    /**
     * Presenter和View绑定
     *
     * @param view View对应的接口
     */
    public void attachView(@NonNull V view) {
        mWeakRefView = new WeakReference<V>(view);
    }

    /**
     * Presenter和View解除绑定
     */
    public void detachView() {
        if (mWeakRefView != null) {
            mWeakRefView.clear();
            mWeakRefView = null;
        }
    }

    /**
     * 返回View对应的接口
     *
     * @return 返回View对应的接口
     */
    @Nullable
    public V getView() {
        if (mWeakRefView != null) {
            return mWeakRefView.get();
        }
        return null;
    }

    /**
     * Presenter和View是否关联
     *
     * @return true是
     */
    public boolean isViewAttached() {
        return mWeakRefView != null && mWeakRefView.get() != null;
    }

}