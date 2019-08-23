package com.m.commonlib;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ming.networkreceiver.NetWorkChange;

public class CommonApplication implements IComponentApplication {

    @Override
    public void onCreate(Application application) {
        //注册网络状态监听广播
        NetWorkChange.register(application);

        // Arouter初始化 SDK
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
    }

    @Override
    public void onTerminate(Application application) {
        //注销网络状态监听广播
        NetWorkChange.unregister(application);
    }

}
