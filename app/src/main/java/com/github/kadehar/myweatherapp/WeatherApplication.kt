package com.github.kadehar.myweatherapp

import android.app.Application
import com.github.kadehar.myweatherapp.feature.weatherscreen.di.weatherModule
import com.github.kadehar.myweatherapp.feature.windscreen.di.windModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(weatherModule, windModule)
        }
    }
}