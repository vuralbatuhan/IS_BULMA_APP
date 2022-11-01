package com.nassssiiii.is_bulma_verme_nku_proje_odev

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val veritabani_adi = "Veritabanim"
val tablo_adi = "Kullanicilar"
val sutun_kullanici_adi = "Kullanici Adi"
val sutun_sifre = "Sifre"
val sutun_id = "Id"

class DataBaseHelper (var context:Context):SQLiteOpenHelper(context,
veritabani_adi,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        //veritabanı olusunca bir kere calisir
        var tabloOlustur = " CREATE TABLE " + tablo_adi + "(" +
                sutun_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                sutun_kullanici_adi + " VARCHAR(256),"+
                sutun_sifre + " VARCHAR(256))"
        db?.execSQL(tabloOlustur)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //veritabanı yukseltmek icin kullanilir
    }

    //veri kaydetmek icin fonksiyon tanimliyoruz
    fun veriKaydet(kullanici: Kullanici){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(sutun_kullanici_adi,kullanici.kullaniciadi)
        cv.put(sutun_sifre,kullanici.sifre)
        var sonuc=db.insert(tablo_adi,null,cv)
        if(sonuc == (-1).toLong()){
            Toast.makeText(context,"KAYIT GERÇEKLEŞEMEDİ",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"KAYIT BAŞARILI",Toast.LENGTH_LONG).show()
        }
    }
}