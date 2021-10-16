package com.github.kadehar.myweatherapp.feature.weatherscreen.data

import com.github.kadehar.myweatherapp.feature.weatherscreen.data.api.model.WeatherModel
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherTemperatureDomainModel
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherWindDomainModel

fun WeatherModel.toDomain(): WeatherDomainModel {
    // TODO: лучше вынеси этот маппинг в отдельную функцию, так как далее эта моделька вероятно попадется в другом месте, и тогда не придется отсюда логику копипастить
    val temperature = WeatherTemperatureDomainModel(
        temperature = this.main.temp,
        minTemperature = this.main.tempMin,
        maxTemperature = this.main.tempMax,
        humidity = this.main.humidity
    )

    val wind = WeatherWindDomainModel(
        speed = this.wind.speed
    )

    return WeatherDomainModel(
        temperature = temperature,
        wind = wind,
        city = this.name
    )
}
