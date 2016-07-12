package com.intro.android;

import android.app.Application;

import timber.log.Timber;

public class NasaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
