package com.github.kadehar.myweatherapp.feature.weatherscreen.di

// TODO: убери эту штуку куда-нибудь в base, так как в di ей делать нечего
object HttpRoutes {
    const val WEATHER_BASE_URL = "https://api.openweathermap.org/"
    const val WEATHER_PATH = "data/2.5/weather"
}
