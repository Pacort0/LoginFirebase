package com.example.miprimeraaplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miprimeraaplicacion.databinding.ActivityRegisterBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnRegistro.setOnClickListener {
            var usuario = binding.campoUsuario.text.toString()
            var password = binding.campoContrasena.text.toString()
            var repPassword = binding.campoRepetirContrasena.text.toString()

            if(password.equals(repPassword) && checkEmptyField(usuario, password, repPassword)) {
                auth.createUserWithEmailAndPassword(usuario, password).addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(applicationContext, "Registro fallido", Toast.LENGTH_SHORT   ).show()
                    }
                }
            } else {
                Toast.makeText(this, "Error en la introducción de datos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnYaCuenta.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun checkEmptyField(usuario: String, password: String, repPassword: String): Boolean {
        return usuario.isNotEmpty() && password.isNotEmpty() && repPassword.isNotEmpty()
    }
}