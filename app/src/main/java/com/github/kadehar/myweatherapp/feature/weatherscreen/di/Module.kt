package com.github.kadehar.myweatherapp.feature.weatherscreen.di

import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.WeatherApi
import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.WeatherRemoteSource
import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.WeatherRepository
import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.WeatherRepositoryImpl
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.WeatherInteractor
import com.github.kadehar.myweatherapp.feature.weatherscreen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(HttpRoutes.WEATHER_BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
    }

    single<WeatherRepository> {
        WeatherRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepository>())
    }

    viewModel<WeatherScreenViewModel> {
        WeatherScreenViewModel(get<WeatherInteractor>())
    }
}