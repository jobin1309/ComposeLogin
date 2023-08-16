package com.example.login_compose.ui.screens

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.login_compose.R
import com.example.login_compose.navigation.ScreensRoute


object Otp {
    const val Otp = 1234
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpScreen(navController: NavController) {

    val context = LocalContext.current

    val focusRequesters = remember { Array(4) { FocusRequester() } }

    val otpDigits = remember { mutableStateListOf("", "", "", "") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        ) {
            otpDigits.forEachIndexed { index, digit ->
                OutlinedTextField(
                    value = digit,
                    onValueChange = { newDigit ->
                        //Taking only digits and of length 1
                        if (newDigit.isDigitsOnly() && newDigit.length <= 1) {
                            otpDigits[index] = newDigit
                            if (newDigit.isNotEmpty() && index < otpDigits.size - 1) {
                                // Move focus to the next text field
                                focusRequesters[index + 1].requestFocus()
                            }
                        }
                    },
                    textStyle = TextStyle.Default.copy(
                        fontSize = 24.sp,
                        color = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = if (index == otpDigits.size - 1) ImeAction.Done else ImeAction.Next
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(58.dp)
                        .background(MaterialTheme.colorScheme.background)
                        .focusRequester(focusRequesters[index])
                        .onFocusChanged { focusState ->
                            if (focusState.isFocused) {
                                focusRequesters[index].requestFocus()

                            }
                        })
            }

        }
        Spacer(modifier = Modifier.height(19.dp))

        Button(
            onClick = {
                var optEntered = otpDigits.joinToString("")
                if (optEntered.toInt() === Otp.Otp) {
                    navController.navigate(ScreensRoute.Home.route)
                } else {
                    Toast.makeText(context, "Please enter a valid OTP", Toast.LENGTH_SHORT).show()
                }
            },
            enabled = otpDigits.all { it.isNotEmpty() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Verify",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
        }
    }
}


