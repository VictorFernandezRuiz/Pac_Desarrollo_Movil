package com.example.pac_desarrollo

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity4 : AppCompatActivity() {

    private lateinit var buttonActivity1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        buttonActivity1 = findViewById(R.id.buttonActivity1)

        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {

        buttonActivity1.setOnClickListener {
            val intento1 = Intent(this, MainActivity::class.java)
            startActivity(intento1)
            Toast.makeText(this, "Nos encontramos en la Activity 1",  Toast.LENGTH_SHORT).show()
        }
    }

}