package com.example.miprimeraaplicacion

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraaplicacion.databinding.ActivityBienvenidaBinding

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuario = intent.getStringExtra("usuario").toString()
        binding.textoBienvenida.text = "¡Bienvenido $usuario!"
        Toast.makeText(applicationContext, "Bienvenido de vuelta, $usuario", Toast.LENGTH_SHORT)
            .show()
        super.onResume()
    }

}