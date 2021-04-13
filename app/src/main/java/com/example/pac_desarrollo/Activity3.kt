package com.example.pac_desarrollo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File

class Activity3 : AppCompatActivity() {
    var ivFoto: ImageView? = null
    var btnTomarFoto: Button? = null
    var btnvolver: Button? = null
    val COD_FOTO = 20
    val CARPETA_RAIZ = "MisFotosApp"
    val CARPETA_IMAGENES = "imagenes"
    val RUTA_IMAGEN = CARPETA_RAIZ + CARPETA_IMAGENES
    var path: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        ivFoto = findViewById(R.id.ivFoto)
       val btnTomarFoto = findViewById<Button>(R.id.btnTomarFoto)
        val btnvolver = findViewById(R.id.btnvolver) as Button
        // PERMISOS PARA ANDROID 6 O SUPERIOR
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                0)
        }
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
            0)
        btnTomarFoto.setOnClickListener(View.OnClickListener { TomarFoto() })
        btnvolver.setOnClickListener(View.OnClickListener { volver() })
    }

    fun TomarFoto() {
        if (isExternalStorageWritable) {
            println("El almacenamiento externo esta disponible")
        } else {
            println("El almacenamiento externo no esta disponible")
        }
        var nombreImagen = ""

//        File fileImagen = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        val fileImagen =
            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                RUTA_IMAGEN)
        println("fileimagen inicio " + fileImagen.path)
        var isCreada = fileImagen.exists()
        if (!isCreada) {
            isCreada = fileImagen.mkdirs()
        }
        if (!isCreada) {
            val context = applicationContext
            Toast.makeText(context, "NO HAY MANERA", Toast.LENGTH_LONG).show()
        }
        if (isCreada) {
            nombreImagen = (System.currentTimeMillis() / 1000).toString() + ".jpg"
            println("creada $nombreImagen")
        }

//        path = Environment.getExternalStorageDirectory()+File.separator+RUTA_IMAGEN+File.separator+nombreImagen;
        path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            .toString() + File.separator + RUTA_IMAGEN + File.separator + nombreImagen
        val imagen = File(path)
        val intent: Intent
        intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val authorities = this.packageName + ".provider"
            val imageUri = FileProvider.getUriForFile(this, authorities, imagen)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen))
        }
        startActivityForResult(intent, COD_FOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == COD_FOTO) {
                MediaScannerConnection.scanFile(this, arrayOf(path),
                    null
                ) { path: String?, uri: Uri? -> }
                val bitmap = BitmapFactory.decodeFile(path)
                ivFoto!!.setImageBitmap(bitmap)
            }
        }
    }

    private val isExternalStorageWritable: Boolean
        private get() {
            val state = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED == state
        }

    fun volver() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}