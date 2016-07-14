package com.intro.android.repository;

import com.intro.android.repository.adapter.NasaRoverRestAdapter;
import com.intro.android.repository.model.RoverData;
import com.intro.android.repository.model.RoverPhoto;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class NasaRepository {

    NasaRoverRestAdapter nasaRoverRestAdapter;

    @Inject
    public NasaRepository(NasaRoverRestAdapter nasaRoverRestAdapter) {
        this.nasaRoverRestAdapter = nasaRoverRestAdapter;
    }

    public Observable<RoverPhoto> downloadCuriosityPhoto() {
        return nasaRoverRestAdapter.rover("curiosity", 1100, "navcam", "DEMO_KEY").map(new Func1<RoverData, RoverPhoto>() {
            @Override
            public RoverPhoto call(RoverData roverData) {
                return roverData.roverPhotoList.get(0);
            }
        });
    }
}
