package com.nassssiiii.is_bulma_verme_nku_proje_odev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nassssiiii.is_bulma_verme_nku_proje_odev.databinding.ActivityKayitOlmaEkraniBinding

class activity_kayit_olma_ekrani : AppCompatActivity() {
    private lateinit var binding: ActivityKayitOlmaEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitOlmaEkraniBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context = this
        var db = DataBaseHelper(context)

        binding.kayitEkraniKayitOl.setOnClickListener {
            var etkullaniciadi = binding.etKullaniciAdiKayitOlma.text.toString()
            var etsifre = binding.etSifreAkyitOlma.text.toString()
            if(etkullaniciadi.isNotEmpty() && etsifre.isNotEmpty()){
                var kullanici = Kullanici(etkullaniciadi,etsifre)
                db.veriKaydet(kullanici)
            }else{
                Toast.makeText(applicationContext,"BOŞ ALANLARI DOLDURUNUZ",Toast.LENGTH_LONG).show()
            }
    }

        binding.kayitEkraniAnaMenuDonme.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}