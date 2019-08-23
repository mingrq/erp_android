package com.m.erp;

import android.app.Application;

import com.m.commonlib.IComponentApplication;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String applicationPath = BuildConfig.ApplicationList;
        String[] applicationPaths = applicationPath.split(",");
        for (int i = 0; i < applicationPaths.length; i++) {
            try {
                Class<?>  zclass = Class.forName(applicationPaths[i]);
                if (zclass != null) {
                    Object objet = zclass.newInstance();
                    if (objet instanceof IComponentApplication) {
                        ((IComponentApplication) objet).onCreate(this);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        String applicationPath = BuildConfig.ApplicationList;
        String[] applicationPaths = applicationPath.split(",");
        for (int i = 0; i < applicationPaths.length; i++) {
            try {
                Class<?>  zclass = Class.forName(applicationPaths[i]);
                if (zclass != null) {
                    Object objet = zclass.newInstance();
                    if (objet instanceof IComponentApplication) {
                        ((IComponentApplication) objet).onTerminate(this);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
