package com.example.profilinteraktif



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AplikasiProfil()
            }
        }
    }
}

@Composable
fun AplikasiProfil(vm: ProfilViewModel = viewModel()) {
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = "beranda"
    ) {
        composable("beranda") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Selamat Datang!",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Aplikasi Profil Mahasiswa")
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { nav.navigate("profil") }
                ) {
                    Text("Buka Profil")
                }
            }
        }

        composable("profil") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        top = 48.dp,
                        bottom = 24.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Profil Mahasiswa",
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(
                    value = vm.nama,
                    onValueChange = { vm.ubahNama(it) },
                    label = { Text("Nama Mahasiswa") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = vm.nim,
                    onValueChange = { vm.ubahNim(it) },
                    label = { Text("NIM") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = vm.prodi,
                    onValueChange = { vm.ubahProdi(it) },
                    label = { Text("Program Studi") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = { nav.navigate("matakuliah") },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Detail Mata Kuliah")
                }

                OutlinedButton(
                    onClick = { nav.popBackStack() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Kembali")
                }
            }
        }

        composable("matakuliah") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Detail Mata Kuliah",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text("Nama: ${vm.nama.ifBlank { "Belum diisi" }}")
                Text("NIM: ${vm.nim.ifBlank { "Belum diisi" }}")
                Text("Program Studi: ${vm.prodi}")

                HorizontalDivider()

                Text("Mata Kuliah: Pemrograman Aplikasi Bergerak")
                Text("Topik: Jetpack Compose dan Android")

                OutlinedButton(
                    onClick = { nav.popBackStack() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Kembali ke Profil")
                }
            }
        }
    }
}