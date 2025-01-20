package com.example.postapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.postapp.ui.screens.PostScreen
import com.example.postapp.ui.screens.UserScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("Bem-vindo ao PostApp!") },
                backgroundColor = MaterialTheme.colors.primarySurface,
                contentColor = Color.White
            )
        },

        bottomBar = {
            BottomNavigation {
                // Item de navegação para a tela de usuários
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Usuários") },
                    label = { Text("Usuários") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )

                BottomNavigationItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Posts") },
                    label = { Text("Posts") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
            }
        }
    ) {

        when (selectedTab) {
            0 -> UserScreen() // Tela de usuários
            1 -> PostScreen() // Tela de posts
        }
    }
}
