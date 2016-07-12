package com.intro.android.injection;

import com.intro.android.MainActivity;

import dagger.Component;

@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
