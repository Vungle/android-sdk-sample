package com.publisher.sample;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class SampleApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        // Enabling MultiDex
        MultiDex.install(base);
        super.attachBaseContext(base);
    }
}
