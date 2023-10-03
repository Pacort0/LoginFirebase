package com.example.miprimeraaplicacion

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.miprimeraaplicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAcceder.setOnClickListener {
            if(binding.campoUsuario.text.toString().isEmpty() || binding.campoContrasena.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this , Bienvenida::class.java)
                intent.putExtra("usuario", binding.campoUsuario.text.toString())
                startActivity(intent)
                Toast.makeText(applicationContext, "Iniciando sesión..." + binding.campoUsuario.text.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}