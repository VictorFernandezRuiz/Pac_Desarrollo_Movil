package com.example.pac_desarrollo

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Activity2 : AppCompatActivity() {


    private lateinit var buttonInsertarDatos: Button
    private lateinit var buttonConsultarDatos: Button
    private lateinit var buttonActivity1: Button
    private lateinit var buttonCrearTabla: Button
    private lateinit var editCodProd: EditText
    private lateinit var editNombre: EditText
    private lateinit var editPrecio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.pac_desarrollo.R.layout.activity_2)

        buttonInsertarDatos = findViewById(R.id.buttonInsertarDatos)
        buttonConsultarDatos = findViewById(R.id.buttonConsultarDatos)
        buttonCrearTabla =  findViewById(R.id.buttonCrearTabla)
        buttonActivity1 = findViewById(R.id.buttonActivity1)
        editCodProd = findViewById(R.id.editCodProd)
        editNombre = findViewById(R.id.editNombre)
        editPrecio = findViewById(R.id.editPrecio)



         buttonInsertarDatos.setOnClickListener {
            val admin = MyOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", editCodProd.getText().toString())
            registro.put("descripcion", editNombre.getText().toString())
            registro.put("precio", editPrecio.getText().toString())
            bd.insert("articulos", null, registro)
            bd.close()
             editCodProd.setText("")
            editNombre.setText("")
            editPrecio.setText("")
            Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()
        }

        buttonConsultarDatos.setOnClickListener {
            val admin = MyOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select descripcion,precio from articulos where codigo=${editCodProd.text.toString()}", null)
            if (fila.moveToFirst()) {
                editNombre.setText(fila.getString(0))
                editPrecio.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
            bd.close()
        }


        buttonActivity1.setOnClickListener {
            val goToActivity1 = Intent(this, MainActivity::class.java)
            startActivity(goToActivity1)
            Toast.makeText(this, "Nos encontramos en la Activity 1", Toast.LENGTH_SHORT).show()

        }



        buttonCrearTabla.setOnClickListener {
            val admin = MyOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            try {
                val colidD = "idD"
                val nombre = "nombre"
                val CREATE_TABLE_DEPT = "CREATE TABLE ${"Tabla2"} ($colidD INTEGER PRIMARY KEY, $nombre TEXT);"
                bd!!.execSQL(CREATE_TABLE_DEPT)

                Toast.makeText(this, "Se ha creado la tabla 'Tabla2' EN LA BASE DE DATOS ", Toast.LENGTH_SHORT).show()

            } catch (e: Exception) {
                Toast.makeText(this, "ERROR al crear la tabla 2" + e.toString(), Toast.LENGTH_LONG).show()
            }


            bd.close()
        }
/*
        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("articulos", "codigo=${et1.text.toString()}", null)
            bd.close()
            et1.setText("")
            editNombre.setText("")
            editPrecio.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
        }

        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("descripcion", editNombre.text.toString())
            registro.put("precio", editPrecio.text.toString())
            val cant = bd.update("articulos", registro, "codigo=${et1.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un artículo con el código ingresado", Toast.LENGTH_SHORT).show()
        }*/
    }

}
