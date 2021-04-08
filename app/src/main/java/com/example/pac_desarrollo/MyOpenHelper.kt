package com.example.pac_desarrollo

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyOpenHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(COMMENTS_TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    companion object {
        private const val COMMENTS_TABLE_CREATE = "CREATE TABLE comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, user TEXT, comment TEXT)"
        private const val DB_NAME = "comments.sqlite"
        private const val DB_VERSION = 1
    }

    fun getLetra(): Cursor {
        val db: SQLiteDatabase = this.getWritableDatabase()
        val sql = "select Letra from Canciones"
        return db.rawQuery(sql, null)
    }

}