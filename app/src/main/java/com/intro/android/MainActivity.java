package com.intro.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.intro.android.injection.DaggerMainComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder().build().inject(this);
        setContentView(R.layout.activity_main);
    }
}
