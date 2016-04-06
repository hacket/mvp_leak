package com.example.zengfansheng.android_mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * MVP对应的基类Activity
 * <p/>
 * V : 是View的接口类型 ,T : 是Presenter的具体类型
 * <p/>
 * Created by zengfansheng on 2016/4/6 0006.
 */
public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    private T mBasePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindPresenter();
    }

    private void bindPresenter() {
        mBasePresenter = createPresenter();

        if (mBasePresenter != null) {
            mBasePresenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindPresenter();
    }

    private void unbindPresenter() {
        if (mBasePresenter != null) {
            mBasePresenter.detachView();
        }
    }

    /**
     * 创建Presenter
     *
     * @return 返回对应的Presenter
     */
    @Nullable
    protected abstract T createPresenter();

}