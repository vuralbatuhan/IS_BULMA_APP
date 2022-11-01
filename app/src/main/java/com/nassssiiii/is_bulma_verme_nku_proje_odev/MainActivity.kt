package com.nassssiiii.is_bulma_verme_nku_proje_odev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nassssiiii.is_bulma_verme_nku_proje_odev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.anaEkranKayitOl.setOnClickListener {

            val intent = Intent(this,activity_kayit_olma_ekrani::class.java)
            startActivity(intent)

        }
    }


}