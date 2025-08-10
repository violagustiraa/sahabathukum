package com.example.sahabathukum

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPermohonanTatapMukaScreen(
    onBackClick: () -> Unit,
    onTerimaClick: () -> Unit,
    onTolakClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                title = { Text("Detail Permohonan") }
            )
        },
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = onTerimaClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B4A6B))
                ) {
                    Text("Terima")
                }
                OutlinedButton(
                    onClick = onTolakClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF3B4A6B)),
                    border = BorderStroke(1.dp, Color(0xFF3B4A6B))
                ) {
                    Text("Tolak")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                InfoRow(Icons.Default.Person, "Nama Pemohon", "Budi Hartono")
                InfoRow(Icons.Default.Event, "Tanggal", "Senin 20 Juli 2025")
                InfoRow(Icons.Default.Schedule, "Waktu", "10.00 WIB")
                InfoRow(Icons.Default.Description, "Tujuan", "Diskusi dan penyerahan dokumen warisan keluarga")
            }

            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Deskripsi Masalah :",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Saya ingin berkonsultasi terkait sengketa hak waris keluarga. Setelah ayah saya meninggal pada tahun 2023 tanpa meninggalkan wasiat tertulis, muncul konflik antara saya dan kakak saya mengenai pembagian harta warisan. Ayah meninggalkan rumah, kendaraan, dan tabungan, namun semua dokumen saat ini dipegang oleh kakak saya secara sepihak.\n\n" +
                                    "Kakak saya mengklaim bahwa ayah pernah menyatakan secara lisan bahwa seluruh harta akan diberikan kepadanya. Ia kini menguasai rumah, mengganti kunci, serta mengusir ibu saya secara tidak langsung. Upaya musyawarah keluarga sudah dilakukan, namun tidak menemukan jalan tengah. Saya memiliki beberapa bukti seperti salinan sertifikat, rekaman percakapan keluarga, serta dokumen keluarga.\n\n" +
                                    "Tujuan saya berkonsultasi adalah untuk mengetahui langkah hukum terbaik agar proses pembagian warisan dapat berlangsung sesuai hukum yang berlaku, serta bila perlu didampingi dalam proses mediasi atau gugatan.",
                            fontSize = 14.sp
                        )
                    }
                }
            }

            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(Icons.Default.AttachFile, contentDescription = null, tint = Color(0xFF3B4A6B))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Dokumen terkait",
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Icon(icon, contentDescription = null, tint = Color(0xFF3B4A6B))
        Spacer(modifier = Modifier.width(8.dp))
        Text("$label : ", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(value, fontSize = 14.sp)
    }
}
