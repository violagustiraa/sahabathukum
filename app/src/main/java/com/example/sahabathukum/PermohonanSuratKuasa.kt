package com.example.sahabathukum

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun PermohonanSuratKuasaScreen(
    pemohonName: String,
    tanggalPengajuan: String,
    keperluan: String,
    status: String,
    statusColor: Color,
    jumlahPermohonan: Int,
    onBackClick: () -> Unit,
    onPemohonClick: () -> Unit,
    onTinjauClick: () -> Unit,
    onTolakClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Permohonan Surat Kuasa") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onPemohonClick() }
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    // Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Permohonan", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        Text(jumlahPermohonan.toString(), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Divider(modifier = Modifier.padding(vertical = 8.dp))

                    // Informasi Pemohon
                    Text(pemohonName, fontWeight = FontWeight.Bold)
                    Text("Diajukan: $tanggalPengajuan", fontSize = 14.sp, color = Color.Gray)
                    Row {
                        Text("Keperluan: ", fontSize = 14.sp, color = Color.Gray)
                        Text(keperluan, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Status & Tombol
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StatusChip(text = status, color = Color(0xFF374151))
                        StatusChip(text = "Tinjau", color = Color(0xFF374151), onClick = onTinjauClick)
                        StatusChip(text = "Tolak", color = Color(0xFF374151), onClick = onTolakClick)
                    }
                }
            }
        }
    }
}

@Composable
fun StatusChip(
    text: String,
    color: Color,
    onClick: (() -> Unit)? = null
) {
    Surface(
        shape = RoundedCornerShape(50),
        color = color,
        contentColor = Color.White,
        onClick = { onClick?.invoke() }
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            fontSize = 12.sp
        )
    }
}