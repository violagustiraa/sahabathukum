package com.example.sahabathukum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LawyerDashboardScreen(
    onKonsultasiClick: () -> Unit,
    onPermohonanTatapMukaClick: () -> Unit,
    onSuratKuasaClick: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        // 🔹 TOP BAR: Search + Profile Icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2E7D32))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Cari Data Pemohon") },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF1B5E20), CircleShape)
                    .padding(6.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 GREETING TEXT
        Text(
            text = "Selamat Datang,\nLawyer Aulia Putri",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 MENU FITUR UTAMA
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DashboardMenuItem(
                iconRes = R.drawable.konsultasi,
                title = "Konsultasi",
                onClick = onKonsultasiClick
            )
            DashboardMenuItem(
                iconRes = R.drawable.permohonantatapmuka,
                title = "Permohonan\nTatap Muka",
                onClick = onPermohonanTatapMukaClick
            )
            DashboardMenuItem(
                iconRes = R.drawable.surat,
                title = "Pembuatan\nSurat Kuasa",
                onClick = onSuratKuasaClick
            )
        }
    }
}

@Composable
fun DashboardMenuItem(iconRes: Int, title: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .width(90.dp)
    ) {
        Surface(
            shape = CircleShape,
            tonalElevation = 4.dp,
            modifier = Modifier.size(70.dp)
        ) {

            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}