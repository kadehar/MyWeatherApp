package com.github.kadehar.myweatherapp.feature.weatherscreen.ui

import android.content.Context
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.kadehar.myweatherapp.R
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel
import com.google.android.material.appbar.MaterialToolbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherScreenActivity : AppCompatActivity() {
    private val weatherViewModel by viewModel<WeatherScreenViewModel>()
    private lateinit var podsAdapter: SimpleAdapter
    private val pods = mutableListOf<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_screen)

        val toolbar: MaterialToolbar = findViewById(R.id.temp_toolbar)
        setSupportActionBar(toolbar)

        val podsList: ListView = findViewById(R.id.temp_pods_list)
        podsAdapter = SimpleAdapter(
            this,
            pods,
            R.layout.item_pod,
            arrayOf("Title", "Content"),
            intArrayOf(R.id.ip_title, R.id.ip_content)
        )
        podsList.adapter = podsAdapter
        weatherViewModel.liveData.observe(this, Observer(::render))

        val city: String = getPreferences(Context.MODE_PRIVATE)
            .getString("city", "Moscow")
            .toString()
        weatherViewModel.requestWeather(city)
    }

    private fun render(state: WeatherDomainModel) {
        pods.clear()
        pods.add(0, HashMap<String, String>().apply {
            put("Title", getString(R.string.temperature))
            put("Content", state.temperature.temperature)
        })
        pods.add(1, HashMap<String, String>().apply {
            put("Title", getString(R.string.min_temperature))
            put("Content", state.temperature.minTemperature)
        })
        pods.add(2, HashMap<String, String>().apply {
            put("Title", getString(R.string.max_temperature))
            put("Content", state.temperature.maxTemperature)
        })
        pods.add(3, HashMap<String, String>().apply {
            put("Title", getString(R.string.humidity))
            put("Content", state.temperature.humidity)
        })

        podsAdapter.notifyDataSetChanged()
    }
}