package com.nassssiiii.is_bulma_verme_nku_proje_odev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nassssiiii.is_bulma_verme_nku_proje_odev.databinding.ActivityGirisYapildiBinding
import com.nassssiiii.is_bulma_verme_nku_proje_odev.databinding.ActivityKayitOlmaEkraniBinding

class activity_kayit_olma_ekrani : AppCompatActivity() {
    private lateinit var binding: ActivityKayitOlmaEkraniBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitOlmaEkraniBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth



    }

    fun onclickbutton(view : View) {
            val email = binding.etKullaniciAdiKayitOlma.text.toString()
            val password = binding.etSifreKayitOlma.text.toString()

            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "LÜTFEN BOŞ ALANLARI DOLDURUNUZ.", Toast.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
