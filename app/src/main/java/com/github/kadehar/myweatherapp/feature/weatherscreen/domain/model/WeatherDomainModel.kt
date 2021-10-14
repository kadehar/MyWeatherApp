package com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model

data class WeatherDomainModel(
    val temperature: WeatherTemperatureDomainModel,
    val wind: WeatherWindDomainModel,
    val city: String
)
