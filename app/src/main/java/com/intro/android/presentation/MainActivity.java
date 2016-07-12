package com.intro.android.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.intro.android.R;
import com.intro.android.presentation.injection.MainComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainComponent.Initializer.init(this).inject(this);
    }
}
