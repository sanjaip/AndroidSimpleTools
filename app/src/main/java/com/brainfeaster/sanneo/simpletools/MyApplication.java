package com.brainfeaster.sanneo.simpletools;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by sanja on 9/19/2017.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
