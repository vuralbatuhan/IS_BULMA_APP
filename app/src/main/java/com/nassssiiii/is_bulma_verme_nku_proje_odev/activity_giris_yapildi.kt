package com.nassssiiii.is_bulma_verme_nku_proje_odev

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nassssiiii.is_bulma_verme_nku_proje_odev.databinding.ActivityGirisYapildiBinding

class activity_giris_yapildi : AppCompatActivity() {
    private lateinit var binding: ActivityGirisYapildiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGirisYapildiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}