package com.intro.android.presentation.injection;

import android.content.Context;

import com.intro.android.presentation.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {

    class Initializer {

        public static MainComponent init(Context context) {
            return DaggerMainComponent.builder().mainModule(new MainModule(context)).build();
        }
    }

    void inject(MainActivity mainActivity);
}
