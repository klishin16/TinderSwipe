package com.example.tinder.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinder.R

class SettingsFragment : Fragment() {

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
                SettingsScreen()
            }
        }
    }
}

@Preview(
    name = "Settings",
    showBackground = true,
)
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .size(140.dp, 140.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_profile_svgrepo_com),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                )
            }

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
            SettingsButton(text = "Save settings")
        }
    }
}

@Composable
fun SettingsText(text: String) {
    Text(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        text = text,
        fontSize = 25.sp,
        textAlign = TextAlign.Center
    )
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
            .background(color = MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = { }
    ) {
        Text(text = text)
    }
}