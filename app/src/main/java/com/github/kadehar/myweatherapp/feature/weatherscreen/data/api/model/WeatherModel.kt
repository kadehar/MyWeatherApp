package com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("main")
    val main: WeatherMainModel,
    @SerializedName("wind")
    val wind: WeatherWindModel,
    @SerializedName("name")
    val name: String
)
/*
{
  "main": {
    "temp": 282.55,
    "feels_like": 281.86,
    "temp_min": 280.37,
    "temp_max": 284.26,
    "pressure": 1023,
    "humidity": 100
  },
  "wind": {
    "speed": 1.5,
    "deg": 350
  },
  "name": "Mountain View"
}
 */