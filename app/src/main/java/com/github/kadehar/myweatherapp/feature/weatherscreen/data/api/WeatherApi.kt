package com.github.kadehar.myweatherapp.feature.weatherscreen.data.api

import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.model.WeatherModel
import com.github.kadehar.myweatherapp.feature.weatherscreen.di.HttpRoutes
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(HttpRoutes.WEATHER_PATH)
    suspend fun getWeather(
        @Query("q") city_name: String,
        @Query("appid") api_key: String = "37065663bb276cbf619fbe6c9a8e2e5a",
        @Query("units") units: String = "metric"
    ) : WeatherModel
}