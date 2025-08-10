package com.example.sahabathukum

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPermohonanSuratKuasaScreen(
    nama: String,
    nik: String,
    email: String,
    telepon: String,
    tanggalPengajuan: String,
    keperluan: String,
    status: String,
    onBackClick: () -> Unit,
    onLihatKTPClick: () -> Unit,
    onLihatSuratPernyataanClick: () -> Unit,
    onSetujuiClick: () -> Unit,
    onTerimaClick: () -> Unit,
    onTolakClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Informasi Pemohon") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = onSetujuiClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(50)
            ) {
                Text("Setujui & Buat Surat Kuasa", fontSize = 16.sp)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Data Pemohon
            Text("Nama", fontWeight = FontWeight.Bold)
            Text(nama)
            Text("NIK", fontWeight = FontWeight.Bold)
            Text(nik)
            Text("Email", fontWeight = FontWeight.Bold)
            Text(email)
            Text("Telepon", fontWeight = FontWeight.Bold)
            Text(telepon)

            // Tanggal Pengajuan
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.CalendarToday, contentDescription = null, tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("Tanggal Pengajuan", fontWeight = FontWeight.Bold)
                    Text(tanggalPengajuan)
                }
            }

            // Keperluan Surat Kuasa
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Description, contentDescription = null, tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("Keperluan Surat Kuasa", fontWeight = FontWeight.Bold)
                    Text(keperluan)
                }
            }

            // Dokumen Pendukung
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Description, contentDescription = null, tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("Dokumen Pendukung", fontWeight = FontWeight.Bold)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = onLihatKTPClick) {
                            Text("Lihat KTP")
                        }
                        OutlinedButton(onClick = onLihatSuratPernyataanClick) {
                            Text("Surat Pernyataan")
                        }
                    }
                }
            }

            // Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Status Saat Ini", fontWeight = FontWeight.Bold)
                Text(status, color = Color.Gray)
            }
        }
    }
}