package com.github.kadehar.myweatherapp.feature.windscreen.di

import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.WeatherInteractor
import com.github.kadehar.myweatherapp.feature.windscreen.ui.WindScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val windModule = module {
    viewModel<WindScreenViewModel> {
        WindScreenViewModel(get<WeatherInteractor>())
    }
}