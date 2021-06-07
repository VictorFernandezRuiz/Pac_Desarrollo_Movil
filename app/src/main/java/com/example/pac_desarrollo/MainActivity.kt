package com.example.pac_desarrollo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import retrofit2.Retrofit
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button
    private lateinit var buttonActivity2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonActivity2 =  findViewById(R.id.buttonActivity2)

        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {
        buttonLogin.setOnClickListener {

          //  val loginEndpoint = URL("http://localhost:8080/apiz-0.0.1-SNAPSHOT/ExecuteLogin/victor/ilerna")
          //  setOnClickListeners(this)
          //  val myConnection: HttpURLConnection = loginEndpoint.openConnection() as HttpURLConnection
          //  if (myConnection.getResponseCode() == 200) {
          //      Toast.makeText(context, "Login'...", Toast.LENGTH_SHORT).show()
          //  } else {
          //      Toast.makeText(context, "ERROR'...", Toast.LENGTH_SHORT).show()



            run("http://localhost:8080/apiz-0.0.1-SNAPSHOT/TestConnectionBBDD")
            Toast.makeText(context, "Login'...", Toast.LENGTH_SHORT).show()
            }



        buttonRegister.setOnClickListener {

            Toast.makeText(context, "Botón de registro pulsado", Toast.LENGTH_SHORT).show()
        }


        buttonActivity2.setOnClickListener{
            val goToActivity2 = Intent(this, Activity2::class.java)
            startActivity(goToActivity2)
            Toast.makeText(this, "Nos encontramos en la Activity 2", Toast.LENGTH_SHORT).show()

        }
    }

    private val client = OkHttpClient()

    fun run(url: String) {
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())


        })
    }

}