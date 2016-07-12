package com.intro.android.repository.adapter;

import com.intro.android.repository.model.RoverData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NasaRoverRestAdapter {

    @GET("rovers/{roverName}/photos")
    Observable<RoverData> rover(@Path("roverName") String roverName, @Query("sol") int sol, @Query("camera") String cameraName,
                                @Query("api_key") String apiKey);
}
