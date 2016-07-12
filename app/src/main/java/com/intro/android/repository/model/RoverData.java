package com.intro.android.repository.model;

import com.squareup.moshi.Json;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class RoverData {

    @Json(name = "photos")
    public List<RoverPhoto> roverPhotoList;
}
