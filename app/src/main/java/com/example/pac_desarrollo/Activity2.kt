package com.example.pac_desarrollo

import android.R
import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Activity2 : AppCompatActivity() {

    private lateinit var buttonCrearTabla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.pac_desarrollo.R.layout.activity_2)
/*        buttonCrearTabla = findViewById(com.example.pac_desarrollo.R.id.buttonCrearTabla)

        val dbHelper = MyOpenHelper(this)
        val db = dbHelper.writableDatabase


        setOnClickListeners(this)*/
    }

  /*   fun setOnClickListeners(context: Context) {
        val fields = arrayOf("first", "last", BaseColumns._ID)
        var dataSource: CursorAdapter
        val dbHelper = MyOpenHelper(this)
        val db = dbHelper.writableDatabase

       *//* buttonCrearTabla.setOnClickListener{
            val data: Cursor = db.MyOpenHelper.onUpgrade("names", fields, null, null, null, null,
                    null)
            Toast.makeText(context, "Tabla names creada...", Toast.LENGTH_SHORT).show()*//*



        }*/
  /*  }*/




}