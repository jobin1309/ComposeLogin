package com.example.login_compose.ui.detail

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.login_compose.R
import com.example.login_compose.ui.home.BoxRows
import com.example.login_compose.ui.home.TopBarIcon
import com.quintetsolutions.qalert.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = "Details", color = Color.White) }, actions = {
                IconButton(onClick = { navController.navigate(Screens.Home.route) }) {
                    //custom function topBarIcon
                    TopBarIcon(imageVector = Icons.Default.KeyboardArrowLeft, "BackArrow", 32)
                };
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        })
    {
        details(Modifier.padding(it))
    }

}

@Composable
fun details(modifier: Modifier) {

    Column(modifier.fillMaxSize()) {

        topDetails()

        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().background(Color.Gray)) {
            Text(
                text = "Issues Overview",
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        //web View
        HalfScreenWebView(url = "https://github.com/")



        //Buttons
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                bottomButtons("Pass")
                Spacer(modifier = Modifier.padding(end = 30.dp))
                bottomButtons("Accept")

            }
        }

    }
}


@Composable
fun topDetails() {
    val DarkOrange = Color(255, 152, 0, 255)

    Column(
        Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        BoxRows(
            modifier = Modifier,
            title = "Afton",
            IconId = R.drawable.projectmanagement,
            TextColor = MaterialTheme.colorScheme.primary,
            FontSize = 25,
            TextPadding = 7,
            contentDescription = "AFTON",
            IconSize = 40,
            StatusText = "Status : Ongoing",
            StatusColor = DarkOrange,
            SpacerPadding = 140,
            rowPadding = 7,
            rowStartPadding = 0
        )

        BoxRows(
            modifier = Modifier,
            "Next in Line - Binish George",
            R.drawable.baseline_assignment_ind_24,
            MaterialTheme.colorScheme.primary,
            18,
            10,
            "CurrentPerson",
            IconSize = 22,
        )

        BoxRows(
            modifier = Modifier,
            title = "Notify's in 5 Minutes",
            IconId = R.drawable.baseline_access_time_24,
            TextColor = MaterialTheme.colorScheme.primary,
            FontSize = 18,
            TextPadding = 10,
            contentDescription = "NextNotifyIn",
            IconSize = 22,
        )
    }


}

@Composable
fun bottomButtons(text: String) {
    ElevatedButton(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary, // Change the background color
            contentColor = MaterialTheme.colorScheme.onPrimary // Change the content (text) color
        )
    ) {
        Text(text = text)
    }
}


@Composable
fun HalfScreenWebView(url: String) {
    Box(
        modifier = Modifier
            .height(450.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Black))
    ) {

        AndroidView(factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        })
    }
}

@Preview
@Composable
fun detailScreenPreview() {
    details(Modifier)
}

