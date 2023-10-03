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
    }

    override fun onPause() {
        Log.i("actividad", "pausen")
        val binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.visibility = View.VISIBLE
        super.onPause()
    }

    override fun onResume() {
        val usuario = intent.getStringExtra("usuario").toString()
        Log.i("actividad", "$usuario")
        val binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textoBienvenida.text = "¡Bienvenido $usuario!"

        Toast.makeText(applicationContext, "Bienvenido de vuelta, $usuario", Toast.LENGTH_SHORT)
            .show()
        super.onResume()
    }

}