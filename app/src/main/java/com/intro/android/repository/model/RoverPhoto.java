package com.intro.android.repository.model;

import com.squareup.moshi.Json;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class RoverPhoto {

    @Json(name = "img_src")
    public String imageUrl;

    @Json(name = "earth_date")
    public String earthDate;
}
