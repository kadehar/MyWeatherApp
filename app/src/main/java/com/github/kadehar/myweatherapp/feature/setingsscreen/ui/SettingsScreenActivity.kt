package com.github.kadehar.myweatherapp.feature.setingsscreen.ui

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.kadehar.myweatherapp.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText

class SettingsScreenActivity : AppCompatActivity() {
    private var text: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_screen)

        val toolbar: MaterialToolbar = findViewById(R.id.settings_toolbar)
        setSupportActionBar(toolbar)

        val cityInput: TextInputEditText = findViewById(R.id.settings_ti_edit)
        cityInput.setOnEditorActionListener {
            _, actonId, _ ->
            when(actonId) {
                EditorInfo.IME_ACTION_DONE -> {
                    text = cityInput.text.toString()
                    Log.d("SETTINGS", "CURRENT CITY IS $text")
                    true
                }
                else -> false
            }
        }

        val saveButton: Button = findViewById(R.id.settings_save_button)
        saveButton.setOnClickListener {
            intent.putExtra("city", text)
            Log.d("SETTINGS",
                "CITY IN INTENT IS ${intent.extras?.getString("city")}")
        }
    }
}