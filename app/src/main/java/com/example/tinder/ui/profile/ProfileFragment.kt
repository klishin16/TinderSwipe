package com.example.tinder.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                ProfileScreen()
            }
        }
    }
}

@Preview(
    name = "Profile",
    showBackground = true,
)
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                EditableText(text = "Name", "Enter your name")
                EditableText(text = "Surname", "Enter your name")
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column() {
                EditableText(text = "Email", "Enter your email")
                EditableText(text = "City", "Enter your city")
                EditableText(text = "Age", "Enter your age")
                EditableText(text = "Hobbies", "Enter your hobbies")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            SettingsButton(text = "Update Profile")
        }
    }
}


@Composable
fun EditableText(text: String, label: String) {
    var innerText = text
    TextField(
        value = innerText,
        onValueChange = { newValue -> innerText = newValue },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        label = { Text(label) },
        placeholder = { Text("placeholder") },
    )
}

@Composable
fun SettingsButton(text: String) {
    Button(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = { }
    ) {
        Text(text = text)
    }
}