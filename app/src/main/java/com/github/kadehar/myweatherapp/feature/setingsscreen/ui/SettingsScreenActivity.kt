package com.github.kadehar.myweatherapp.feature.setingsscreen.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import com.github.kadehar.myweatherapp.R
import com.github.kadehar.myweatherapp.feature.setingsscreen.data.datastore.KEY
import com.github.kadehar.myweatherapp.feature.setingsscreen.data.datastore.dataStore
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.runBlocking

// TODO: сделай пул реквестом домашку отдельно пж
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
                    true
                }
                else -> false
            }
        }

        val saveButton: Button = findViewById(R.id.settings_save_button)
        // TODO: есть такая проблема в андроиде, что при желании, ты сможешь взять и нажать на две кнопки одновременно, или даже на одну кнопку два раза если очень постараться, поэтому мы юзаем тротлы, которые изначально вытащили из роботов
/*fun View.setThrottledClickListener(delay: Long = 200L, onClick: (View) -> Unit) {
    setOnClickListener {
        throttle(delay) {
            onClick(it)
        }
    }
}

private var lastClickTimestamp = 0L
fun View.throttle(delay: Long = DEFAULT_THROTTLE_DELAY, action: () -> Unit): Boolean {
    val currentTimestamp = System.currentTimeMillis()
    val delta = currentTimestamp - lastClickTimestamp
    if (delta !in 0L..delay) {
        lastClickTimestamp = currentTimestamp
        action()
        return true
    }
    return false
}
*/        
        saveButton.setOnClickListener {
            saveCity(text)
        }
    }

    private fun saveCity(city: String) {
        // TODO: тут надо запустить на лайфсайкле активити viewLifecycleOwner.lifecycle.coroutineScope, иначе runBlocking тебе ui залочит
        runBlocking {
            dataStore.edit {
                prefs -> prefs[KEY] = city
            }
        }
    }
}
