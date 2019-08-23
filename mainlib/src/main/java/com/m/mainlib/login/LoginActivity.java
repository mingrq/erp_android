package com.m.mainlib.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.m.commonlib.routepath.MainRoutePath;
import com.m.mainlib.R;

@Route(path = MainRoutePath.LOGIN_ACTIVITY)
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_login);
    }
}
