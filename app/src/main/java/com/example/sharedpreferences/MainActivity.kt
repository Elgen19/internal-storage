package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var pushNotificationSwitch: SwitchCompat
    private lateinit var darkModeSwitch: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)

        pushNotificationSwitch = findViewById(R.id.pushNotificationSwitch)
        darkModeSwitch = findViewById(R.id.darkModeSwitch)

        // Load the saved settings
        pushNotificationSwitch.isChecked = sharedPreferences.getBoolean("push_notification", false)
        darkModeSwitch.isChecked = sharedPreferences.getBoolean("dark_mode", false)

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            saveSettings()
        }
    }

    private fun saveSettings() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("push_notification", pushNotificationSwitch.isChecked)
        editor.putBoolean("dark_mode", darkModeSwitch.isChecked)
        editor.apply()

        Toast.makeText(this, "Settings saved successfully", Toast.LENGTH_SHORT).show()
    }
}
