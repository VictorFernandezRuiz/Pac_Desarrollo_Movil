package com.example.pac_desarrollo

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var buttonPlay: Button
    private lateinit var buttonPause: Button
    private lateinit var buttonStop: Button
    private lateinit var buttonActivity2: Button
    private lateinit var buttonActivity3: Button
    private lateinit var buttonActivity4: Button

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlay = findViewById(R.id.buttonPlay)
        buttonPause = findViewById(R.id.buttonPause)
        buttonStop = findViewById(R.id.buttonStop)
        buttonActivity2 = findViewById(R.id.buttonActivity2)
        buttonActivity3 = findViewById(R.id.buttonActivity3)
        buttonActivity4 = findViewById(R.id.buttonActivity4)
        mediaPlayer = MediaPlayer.create(this, R.raw.milan)

        setOnClickListeners(this)

    }

    private fun setOnClickListeners(context: Context) {
        buttonPlay.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(context, "Se reproduce la canción 'Milan'...", Toast.LENGTH_SHORT).show()
        }

        buttonPause.setOnClickListener {
            mediaPlayer.pause()
            Toast.makeText(context, "Canción pausada", Toast.LENGTH_SHORT).show()
        }

        buttonStop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, R.raw.milan)
            Toast.makeText(context, "Parando...", Toast.LENGTH_SHORT).show()
        }
        buttonActivity2.setOnClickListener{
            val goToActivity2 = Intent(this, Activity2::class.java)
            startActivity(goToActivity2)
            Toast.makeText(this, "Nos encontramos en la Activity 2",  Toast.LENGTH_SHORT).show()

        }
        buttonActivity3.setOnClickListener {
            val intento1 = Intent(this, Activity3::class.java)
            startActivity(intento1)
            Toast.makeText(this, "Nos encontramos en la Activity 3",  Toast.LENGTH_SHORT).show()
        }

        buttonActivity4.setOnClickListener {
            val intento1 = Intent(this, Activity4::class.java)
            startActivity(intento1)
            Toast.makeText(this, "Nos encontramos en la Activity 4",  Toast.LENGTH_SHORT).show()
        }
    }
    


}