package com.github.kadehar.myweatherapp.feature.weatherscreen.data.api

import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherDomainModel
}