package com.seetatech.seetaverify;

import android.app.Application;
import android.util.Log;


public class SeetaApplication extends Application {

    private static SeetaApplication instance;

    public static SeetaApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Log.i("SeetaApplication", "onCreate");


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
