package com.github.kadehar.myweatherapp.feature.weatherscreen.data.api

import com.github.kadehar.myweatherapp.feature.weatherscreen.data.toDomain
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel

class WeatherRepositoryImpl(private val source: WeatherRemoteSource) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherDomainModel {
        return source.getWeather(city).toDomain()
    }
}