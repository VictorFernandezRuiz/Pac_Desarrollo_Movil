package com.example.pac_desarrollo

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    // VICTOR FERNANDEZ RUIZ para Ilerna

    override fun onCreate(db: SQLiteDatabase) {


        db.execSQL("create table articulos(codigo int primary key, descripcion text, precio real)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}