package com.example.sahabathukum

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class untuk menyimpan pesan
data class Message(
    val sender: String,
    val time: String,
    val content: String,
    val isFromUser: Boolean
)

@Composable
fun ChatDetailScreen(
    onBackClick: () -> Unit,
    contactName: String
) {
    var messageText by remember { mutableStateOf("") }
    var messages by remember {
        mutableStateOf(
            listOf(
                Message("Budi Hartono", "10.00", "Selamat pagi Pak, saya ingin konsultasi hukum", isFromUser = true),
                Message("Lawyer", "10.05", "Selamat pagi pak Budi, ada yang bisa saya bantu?", isFromUser = false)
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onBackClick() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = contactName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Chat area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                .padding(12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                messages.forEach { message ->
                    ChatBubble(message)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Input Pesan
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black, RoundedCornerShape(24.dp))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                placeholder = { Text("Ketik Pesan") },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )

            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Kirim Pesan",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        if (messageText.isNotBlank()) {
                            val newMessage = Message("Lawyer", "10.10", messageText, isFromUser = false)
                            messages = messages + newMessage
                            messageText = ""
                        }
                    }
            )
        }
    }
}

@Composable
fun ChatBubble(message: Message) {
    val alignment = if (message.isFromUser) Alignment.Start else Alignment.End
    val bubbleColor = if (message.isFromUser) Color(0xFFE0E0E0) else Color(0xFFF5F5F5)

    Column(
        horizontalAlignment = alignment,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(bubbleColor, shape = RoundedCornerShape(16.dp))
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = "${message.sender} • ${message.time}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = message.content,
                    fontSize = 14.sp
                )
            }
        }
    }
}

