package com.nafhan.myapplication.entity

import java.io.Serializable

class TiketPemesanan: Serializable {
// namaPemesan, jamKeberangkatan, tanggalKeberangkatan,tujuan only
    private var namaPemesan: String = ""
    private var jamKeberangkatan: String = ""
    private var tanggalKeberangkatan: String = ""
    private var tujuan: String = ""
    private var harga: Int = 0

    fun setNamaPemesan(namaPemesan: String){
        this.namaPemesan = namaPemesan
    }

    fun getNamaPemesan(): String{
        return namaPemesan
    }

    fun setJamKeberangkatan(jamKeberangkatan: String){
        this.jamKeberangkatan = jamKeberangkatan
    }

    fun getJamKeberangkatan(): String{
        return jamKeberangkatan
    }

    fun setTanggalKeberangkatan(tanggalKeberangkatan: String){
        this.tanggalKeberangkatan = tanggalKeberangkatan
    }

    fun getTanggalKeberangkatan(): String{
        return tanggalKeberangkatan
    }

    fun setTujuan(tujuan: String){
        this.tujuan = tujuan
    }

    fun getTujuan(): String{
        return tujuan
    }

    fun setHarga(harga: Int){
        this.harga = harga
    }

    fun getHarga(): Int{
        return harga
    }
}