package com.m.commonlib;

import android.app.Application;

public interface IComponentApplication {
    // Application创建
    void onCreate(Application application);

    // Application终止
    void onTerminate(Application application);
}
