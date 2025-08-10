package com.example.sahabathukum

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "splash",
        modifier = modifier
    ) {
        // Splash
        composable("splash") {
            SplashScreen(navController = navController)
        }

        // Login
        composable("login") {
            LoginScreen(
                onLoginClick = {
                    navController.navigate("Login2") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onSignUpClick = {
                    navController.navigate("signup")
                }
            )
        }

        // Sign Up
        composable("signup") {
            SignUpScreen(
                onNextClick = { navController.navigate("datadiri") },
                onLoginClick = { navController.navigate("Login2") }
            )
        }

        // Data Diri
        composable("datadiri") {
            DataDiriScreen(
                onNextClick = { navController.navigate("masukanfoto") }
            )
        }

        // Upload Foto
        composable("masukanfoto") {
            UploadPhotoScreen(
                onSelesaiClick = {
                    navController.navigate("home") {
                        popUpTo("masukanfoto") { inclusive = true }
                    }
                }
            )
        }

        // Login 2
        composable("Login2") {
            LoginScreen2(
                onSignUpClick = { navController.navigate("signup") },
                onLoginClick = {
                    navController.navigate("home") {
                        popUpTo("Login2") { inclusive = true }
                    }
                }
            )
        }

        // Home
        composable("home") {
            LawyerDashboardScreen(
                onKonsultasiClick = { navController.navigate("chatlist") },
                onPermohonanTatapMukaClick = { navController.navigate("permohonanTatapMuka") },
                onSuratKuasaClick = { // Klik Pembuatan Surat Kuasa
                    navController.navigate("permohonanSuratKuasa")
                }
            )
        }

        // Permohonan Tatap Muka
        composable("permohonanTatapMuka") {
            PermohonanTatapMukaScreen(
                onBackClick = { navController.popBackStack() },
                onChatClick = { navController.navigate("detailPermohonanTatapMuka") }
            )
        }

        // Detail Permohonan Tatap Muka
        composable("detailPermohonanTatapMuka") {
            DetailPermohonanTatapMukaScreen(
                onBackClick = { navController.popBackStack() },
                onTerimaClick = { navController.navigate("chatscreen") },
                onTolakClick = { /* aksi tolak */ }
            )
        }

        // Permohonan Surat Kuasa
        composable("permohonanSuratKuasa") {
            PermohonanSuratKuasaScreen(
                pemohonName = "Budi Hartono",
                tanggalPengajuan = "22 Jul 2025",
                keperluan = "Kasus Perdata",
                status = "Belum diproses",
                statusColor = Color.Gray,
                jumlahPermohonan = 1,
                onBackClick = { navController.popBackStack() },
                onPemohonClick = { // Klik nama pemohon
                    navController.navigate("detailPermohonanSuratKuasa")
                },
                onTinjauClick = { navController.navigate("detailPermohonanSuratKuasa") },
                onTolakClick = { /* aksi tolak */ }
            )
        }

        // Detail Permohonan Surat Kuasa
        composable("detailPermohonanSuratKuasa") {
            DetailPermohonanSuratKuasaScreen(
                onBackClick = { navController.popBackStack() },
                onTerimaClick = { navController.navigate("chatscreen") },
                onTolakClick = { /* aksi tolak */ },
                nama = "",
                nik = "",
                email = "",
                telepon = "",
                tanggalPengajuan = "",
                keperluan = "",
                status = "",
                onLihatKTPClick = {},
                onLihatSuratPernyataanClick = {},
                onSetujuiClick = {}
            )
        }

        // Chat Screen
        composable("chatscreen") {
            ChatScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        // Chat list
        composable("chatlist") {
            ChatListScreen(
                onBackClick = {
                    navController.navigate("home") {
                        popUpTo("chatlist") { inclusive = true }
                    }
                },
                onChatClick = {
                    navController.navigate("chatdetail/${Uri.encode("Chat Umum")}")
                },
                onAddClick = { navController.navigate("contactlist") }
            )
        }

        // Chat detail
        composable(
            route = "chatdetail/{contactName}",
            arguments = listOf(
                navArgument("contactName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val contactName = backStackEntry.arguments?.getString("contactName") ?: ""
            ChatDetailScreen(
                onBackClick = { navController.popBackStack() },
                contactName = contactName
            )
        }

        // Contact list
        composable("contactlist") {
            ContactListScreen(
                onBackClick = { navController.popBackStack() },
                onContactClick = { contactName ->
                    val encoded = Uri.encode(contactName)
                    navController.navigate("infokontak/$encoded")
                }
            )
        }

        // Info kontak
        composable(
            route = "infokontak/{contactName}",
            arguments = listOf(
                navArgument("contactName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val contactName = backStackEntry.arguments?.getString("contactName") ?: ""
            InfoKontakScreen(
                onBackClick = { navController.popBackStack() },
                onSendMessage = {
                    navController.navigate("chatdetail/${Uri.encode(contactName)}")
                },
                contactName = contactName
            )
        }
    }
}