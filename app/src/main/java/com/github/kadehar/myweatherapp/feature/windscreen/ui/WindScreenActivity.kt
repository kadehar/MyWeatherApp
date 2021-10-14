package com.github.kadehar.myweatherapp.feature.windscreen.ui

import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.kadehar.myweatherapp.R
import com.github.kadehar.myweatherapp.feature.weatherscreen.domain.model.WeatherDomainModel
import com.google.android.material.appbar.MaterialToolbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class WindScreenActivity : AppCompatActivity() {
    private val windViewModel by viewModel<WindScreenViewModel>()
    private lateinit var podsAdapter: SimpleAdapter
    private val pods = mutableListOf<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind_screen)

        val toolbar: MaterialToolbar = findViewById(R.id.ws_toolbar)
        setSupportActionBar(toolbar)

        val podsList: ListView = findViewById(R.id.ws_pods_list)
        podsAdapter = SimpleAdapter(
            this,
            pods,
            R.layout.item_pod,
            arrayOf("Title", "Content"),
            intArrayOf(R.id.ip_title, R.id.ip_content)
        )
        podsList.adapter = podsAdapter
        windViewModel.liveData.observe(this, Observer(::render))

        val city: String = intent.extras?.getString("city").toString()
        Log.d("SETTINGS", "CITY NOW IS $city")
        windViewModel.requestWind(city)
    }

    private fun render(state: WeatherDomainModel) {
        pods.clear()
        pods.add(0, HashMap<String, String>().apply {
            put("Title", getString(R.string.speed))
            put("Content", state.wind.speed)
        })
        podsAdapter.notifyDataSetChanged()
    }
}