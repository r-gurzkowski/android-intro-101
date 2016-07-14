package com.intro.android.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.intro.android.R;
import com.intro.android.presentation.injection.MainComponent;
import com.intro.android.repository.NasaRepository;
import com.intro.android.repository.model.RoverPhoto;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    NasaRepository nasaRepository;
    @Inject
    Picasso picasso;
    @BindView(R.id.imageview)
    ImageView imageView;
    @BindView(R.id.textview)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainComponent.Initializer.init(this).inject(this);
        ButterKnife.bind(this);
        nasaRepository.downloadCuriosityPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RoverPhoto>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RoverPhoto roverPhoto) {
                picasso.load(roverPhoto.imageUrl).into(imageView);
                textView.setText(roverPhoto.earthDate);
            }
        });
    }
}
