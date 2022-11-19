package com.nassssiiii.is_bulma_verme_nku_proje_odev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nassssiiii.is_bulma_verme_nku_proje_odev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        signUp()
        signIn()

        }

    fun signUp() = binding.anaEkranKayitOl.setOnClickListener {
        val intent = Intent(this,activity_kayit_olma_ekrani::class.java)
        startActivity(intent)
    }


   /* fun signUp() = binding.anaEkranKayitOl.setOnClickListener {
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this,"BOŞ ALANLARI DOLDURUNUZ",Toast.LENGTH_SHORT).show()
        }else{
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                val intent = Intent(this,activity_giris_yapildi::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,"FAILED",Toast.LENGTH_SHORT).show()
            }
        }
    }*/

    fun signIn() = binding.anaEkranGirisYap.setOnClickListener {
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this,"BOŞ ALANLARI DOLDURUNUZ",Toast.LENGTH_LONG).show()
        }else{
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                val intent = Intent(this,activity_giris_yapildi::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this,"BİLGİLERİNİZ YANLIŞ. LÜTFEN YENİDEN KONTROL EDİNİZ.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}