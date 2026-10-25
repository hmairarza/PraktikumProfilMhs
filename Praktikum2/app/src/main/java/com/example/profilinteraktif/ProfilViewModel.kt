package com.example.profilinteraktif


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfilViewModel : ViewModel() {

    var nama by mutableStateOf("")
        private set

    var nim by mutableStateOf("")
        private set

    var prodi by mutableStateOf("Informatika")
        private set

    fun ubahNama(input: String) {
        nama = input
    }

    fun ubahNim(input: String) {
        nim = input
    }

    fun ubahProdi(input: String) {
        prodi = input
    }
}
