package com.example.zengfansheng.android_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        TextView tv = (TextView) findViewById(R.id.tv);
        String user = getIntent().getStringExtra("user");
        String pwd = getIntent().getStringExtra("pwd");
        tv.setText(user + ":" + pwd);
    }

}