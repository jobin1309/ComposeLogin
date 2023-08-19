package com.example.login_compose.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.login_compose.R
import com.quintetsolutions.qalert.navigation.Screens


object email {
    const val email = "email"
}

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        //Icon function
        Logo()

        Spacer(modifier = Modifier.height(200.dp))

        //SignInText
        Text(
            text = stringResource(id = R.string.sign_in_text),
            fontSize = 34.sp,
            fontFamily = FontFamily.SansSerif,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
        )

        //Space
        Spacer(modifier = Modifier.padding(bottom = 30.dp))

        //Text field for email
        EmailTextField(modifier = Modifier)


        Spacer(modifier = Modifier.height(32.dp))

        // Sign-in Button
        SignInButton(navController)

    }
}

@Composable
fun Logo() {
    Box(modifier = Modifier.size(300.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.logo_alert),
            contentDescription = "logo",
            Modifier
                .clip(RoundedCornerShape(14.dp)),
            contentScale = ContentScale.Crop

        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(modifier: Modifier) {

    var email by remember { mutableStateOf("") }


    val iconPadding = 1.dp
    val iconSize = 24.dp
    val textFieldHeight = 70.dp


    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text(stringResource(id = R.string.email_text)) },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = modifier
                    .size(iconSize)
                    .padding(iconPadding)
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        modifier = Modifier
            .fillMaxWidth()
            .height(textFieldHeight)

    )
}

@Composable
fun SignInButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(Screens.Otp.route) },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Text(
            text = stringResource(id = R.string.sign_button_text),
            color =  MaterialTheme.colorScheme.onPrimary,
            fontSize = 22.sp
        )
    }
}


@Composable
@Preview(showBackground = true)
fun previewLoginScreen() {
    LoginScreen(rememberNavController())
}