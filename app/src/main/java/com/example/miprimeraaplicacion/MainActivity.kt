package com.example.miprimeraaplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miprimeraaplicacion.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAcceder.setOnClickListener {
            val usuario = binding.campoUsuario.text.toString()
            val password = binding.campoContrasena.text.toString()
            if(checkEmptyField(usuario, password)){
                auth.signInWithEmailAndPassword(usuario, password).addOnCompleteListener (this) {
                        task -> if (task.isSuccessful){
                    intent.putExtra("usuario", binding.campoUsuario.text.toString())
                    startActivity(Intent(this, Bienvenida::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
                }
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnNoCuenta.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

    private fun checkEmptyField(usuario: String, password: String): Boolean {
        return usuario.isNotEmpty() && password.isNotEmpty()
    }
}