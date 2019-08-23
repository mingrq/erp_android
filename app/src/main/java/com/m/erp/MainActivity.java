package com.m.erp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.m.commonlib.routepath.MainRoutePath;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(MainRoutePath.WELCOME_ACTIVITY).navigation();
        finish();
    }
}
