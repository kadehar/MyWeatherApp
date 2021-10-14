package com.github.kadehar.myweatherapp.feature.weatherscreen.domain

import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.WeatherRepository
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun getWeather(city: String): WeatherDomainModel {
        return repository.getWeather(city)
    }
}