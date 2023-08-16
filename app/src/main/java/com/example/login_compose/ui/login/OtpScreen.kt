package com.example.login_compose.ui.login

import android.content.Context
import android.widget.ScrollView
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.login_compose.R
import com.example.login_compose.navigation.ScreensRoute
import com.example.login_compose.ui.login.InvalidPinAlertDialog as InvalidPinAlertDialog


object Otp {
    const val Otp = 1234
}

@Composable
fun OTPScreen(navController: NavController) {
    val context = LocalContext.current

    val focusRequester = remember { Array(4) { FocusRequester() } }

    val otpDigits = remember { mutableStateListOf("", "", "", "") }

    Column(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.padding(20.dp))
        //Otp heading
        OtpText()

        Spacer(modifier = Modifier.padding(100.dp))

        //Enter the Otp text
        Text(text = stringResource(id = R.string.otp_text), fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))


        //Each otp digit row
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            otpDigits.forEachIndexed { index, value ->

                OtpDigitBox(
                    optDigits = otpDigits,
                    index = index,
                    focusRequester = focusRequester
                )

            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        //Otp button
        OtpButton(otpDigits = otpDigits, context, navController)
    }
}

@Composable
fun OtpText() {
    Text(
        text = stringResource(id = R.string.otp_name),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )

}


@Composable
fun OtpButton(otpDigits: List<String>, context: Context, navController: NavController) {

    var isInvalidPinDialogVisible by remember { mutableStateOf(false) }


    Button(
        onClick = {
            val otpEntered = otpDigits.joinToString("")
            if (otpEntered.toInt() == Otp.Otp) {
                //Navigate to Home screen
                navController.navigate(ScreensRoute.Home.route)
            } else {
                isInvalidPinDialogVisible = !isInvalidPinDialogVisible;
                Toast.makeText(context, R.string.incorrect_otp, Toast.LENGTH_SHORT).show()
            }

        },
        shape = RoundedCornerShape(18.dp),
        enabled = otpDigits.all { it.isNotEmpty() },
        modifier = Modifier
            .fillMaxWidth()


    ) {
        Text(text = stringResource(id = R.string.verify_otp), fontSize = 25.sp, color = Color.White)
    }

    if (isInvalidPinDialogVisible) {
        InvalidPinAlertDialog(
            onDismiss = {
                isInvalidPinDialogVisible = false
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpDigitBox(
    optDigits: SnapshotStateList<String>,
    index: Int,
    focusRequester: Array<FocusRequester>
) {


    val value = optDigits.getOrNull(index) ?: ""

    OutlinedTextField(value = value,
        onValueChange = { newDigit ->
            if (newDigit.isDigitsOnly() && newDigit.length <= 1) {
                //Taking only Integer and of length 1
                optDigits[index] = newDigit

                if (newDigit.isNotEmpty() && index < optDigits.size - 1) {
                    //move focus to the next field
                    focusRequester[index + 1].requestFocus()
                }
            }
        },
        textStyle = TextStyle.Default.copy(
            fontSize = 24.sp, color = Color.Black
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = if (index < optDigits.size - 1) ImeAction.Done else ImeAction.Next
        ),
        singleLine = true,
        modifier = Modifier
            .padding(4.dp)
            .size(60.dp)
            .background(MaterialTheme.colorScheme.background)
            .focusRequester(focusRequester[index])
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    focusRequester[index].requestFocus()
                }
            })
}


@Composable
fun InvalidPinAlertDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_warning_amber_24),
                contentDescription = "Warning Icon"
            )
        },
        title = {
            Text(text = "Invalid PIN")
        },
        text = {
            Text(text = "The entered PIN does not match the correct OTP.")
        },
        confirmButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                ) {
                    Text(text = "OK")
                }
            }
        }
    )
}



