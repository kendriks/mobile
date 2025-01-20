package com.example.postapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.postapp.data.models.Post

@Composable
fun PostItem(
    post: Post,
    onDelete: (Int) -> Unit,
    onEdit: (Post) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = post.content, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Button(
                    onClick = {showDialog = true},
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Deletar")
                }

            }

            if(showDialog) {
                AlertDialog(
                    onDismissRequest = {showDialog = false},
                    title = {Text(text = "Deletar Post")},
                    text = {Text(text = "Tem certeza? O post deletado não poderá ser recuperado")},
                    confirmButton = {
                        TextButton(onClick = {
                            onDelete(post.id)
                            showDialog = false
                        }) {
                            Text(text = "Sim", color = Color.Red)
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = {showDialog = false}) {
                            Text(text = "Não")
                        }
                    }
                )
            }

        }
    }

}