package com.example.sahabathukum

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatListScreen(
    onBackClick: () -> Unit,
    onChatClick: () -> Unit,
    onAddClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Row: Back, Search Bar, Icons
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Cari Pemohon") },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF0F0F0),
                    focusedContainerColor = Color.White,
                    disabledContainerColor = Color.LightGray
                ),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onAddClick() }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Filter Buttons
        Row {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE0E0E0)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Semua", color = Color.Black)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E3A8A),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Belum dibaca")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Chat Bubble Items
        ChatItem(
            name = "Budi Hartono",
            message = "Selamat Pagi pak, saya ingin konsultasi hukum.\nApakah Bapak bisa bantu saya?",
            time = "09.00 Senin 20 Juli 2025",
            onClick = onChatClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        ChatItem(
            name = "Yulilo Andrian",
            message = "Selamat Pagi pak, saya ingin konsultasi hukum.\nApakah Bapak bisa bantu saya?",
            time = "08.00 Senin 20 Juli 2025",
            onClick = onChatClick
        )
    }
}

@Composable
fun ChatItem(
    name: String,
    message: String,
    time: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            .padding(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = time, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = message, fontSize = 12.sp, color = Color.Gray)
    }
}

