package com.github.kadehar.myweatherapp.feature.weatherscreen.data.api

import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.model.WeatherModel

class WeatherRemoteSource(private val api: WeatherApi) {
    suspend fun getWeather(city: String): WeatherModel = api.getWeather(city_name = city)
}