package com.github.kadehar.myweatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.kadehar.myweatherapp.feature.setingsscreen.ui.SettingsScreenActivity
import com.github.kadehar.myweatherapp.feature.weatherscreen.ui.WeatherScreenActivity
import com.github.kadehar.myweatherapp.feature.windscreen.ui.WindScreenActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tm_weather -> {
                Intent(this, WeatherScreenActivity::class.java).also {
                    startActivity(it)
                }
            }
            R.id.tm_wind -> {
                Intent(this, WindScreenActivity::class.java).also {
                    startActivity(it)
                }
            }
            R.id.tm_settings -> {
                Intent(this, SettingsScreenActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}