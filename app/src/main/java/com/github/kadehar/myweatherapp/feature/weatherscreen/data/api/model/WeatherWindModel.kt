package com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherWindModel(
    @SerializedName("speed")
    val speed: String,
    @SerializedName("deg")
    val deg: String
)

/*
"wind": {
    "speed": 1.5,
    "deg": 350
}*/
