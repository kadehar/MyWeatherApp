package com.github.kadehar.myweatherapp.feature.windscreen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.WeatherInteractor
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WindScreenViewModel(private val interactor: WeatherInteractor) : ViewModel() {
    val liveData: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWind(city: String) {
        viewModelScope.launch {
            liveData.postValue(interactor.getWeather(city))
        }
    }
}