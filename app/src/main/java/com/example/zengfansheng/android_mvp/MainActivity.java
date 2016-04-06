package com.example.zengfansheng.android_mvp;

import com.example.zengfansheng.android_mvp.base.MVPBaseActivity;
import com.example.zengfansheng.android_mvp.model.User;
import com.example.zengfansheng.android_mvp.presenter.UserLoginPresenter;
import com.example.zengfansheng.android_mvp.view.ILoginView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends MVPBaseActivity<ILoginView, UserLoginPresenter> implements ILoginView {

    private EditText username;
    private EditText pwd;
    private ProgressBar progressBar;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.pb);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);

        errorText = (TextView) findViewById(R.id.error_text);
    }

    @Override
    protected UserLoginPresenter createPresenter() {
        return new UserLoginPresenter(this);
    }

    public void login(View view) {
        UserLoginPresenter userLoginPresenter = createPresenter();
        userLoginPresenter.login();
    }

    public void about(View view) {
        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoginSuccess(User user) {
        Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
        intent.putExtra("user", user.username);
        intent.putExtra("pwd", user.pwd);
        startActivity(intent);
    }

    @Override
    public void showLoginFailed(User user, String errorMsg) {
        username.setVisibility(View.INVISIBLE);
        pwd.setVisibility(View.INVISIBLE);
        errorText.setVisibility(View.VISIBLE);
        errorText.setText(errorMsg);
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPwd() {
        return pwd.getText().toString();
    }

}