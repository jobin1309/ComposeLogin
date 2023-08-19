package com.example.login_compose.ui.home


import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login_compose.R
import com.quintetsolutions.qalert.navigation.Screens

import java.sql.Time


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Alerts", color = Color.White) },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        TopBarIcon(imageVector = Icons.Default.Search, "SearchIcon")
                    };
                    IconButton(onClick = { /*TODO*/ }) {
                        TopBarIcon(imageVector = Icons.Default.AccountCircle, contentDescription = "UserAccount")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            items(100) {
                homeListBox(navController)
            }

        }
    }

}



@Composable
fun TopBarIcon(imageVector: ImageVector, contentDescription: String, iconSize : Int = 20) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = Color.Gray,
        modifier = Modifier.size(iconSize.dp)
    )
}

@Composable
fun homeListBox(navController: NavController) {

    Spacer(modifier = Modifier)
    Box(
        modifier = Modifier
            .height(300.dp)
            .padding(7.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(8.dp))
            .clickable { navController.navigate(Screens.Detail.route) },

        contentAlignment = Alignment.Center

    ) {
        Column() {

            BoxRows(
                modifier = Modifier,
                title = "Afton",
                IconId = R.drawable.projectmanagement,
                TextColor = MaterialTheme.colorScheme.primary,
                FontSize = 25,
                TextPadding = 7,
                contentDescription = "AFTON",
                IconSize = 40,
                StatusText = "Status : Pending",
                SpacerPadding = 100,
                rowPadding = 7,
                rowStartPadding = 0
            )

            BoxRows(
                modifier = Modifier,
                title = "Crash occurred when user login",
                IconId = R.drawable.baseline_warning_amber_24,
                TextColor = MaterialTheme.colorScheme.primary,
                FontSize = 18,
                IconSize = 22,
                TextPadding = 10,
                contentDescription = "Alert"
            )
            BoxRows(
                modifier = Modifier,
                title = "Alerted @9:00pm 24th June 2023 to Engineer Noel Jose",
                IconId = R.drawable.baseline_access_time_filled_24,
                TextColor = MaterialTheme.colorScheme.primary,
                FontSize = 18,
                IconSize = 22,
                TextPadding = 10,
                contentDescription = "Time"
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
        Row(
            Modifier
                .padding(start = 291.dp)
                .padding(top = 190.dp)
        ) {
            Icon(

                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Moves to detail page",
                Modifier.size(40.dp)
            )
        }
    }
}


@Composable
fun BoxRows(
    modifier: Modifier,
    title: String,
    IconId: Int,
    TextColor: Color,
    FontSize: Int,
    TextPadding: Int,
    contentDescription: String,
    StatusColor: Color = Color.Red,
    IconSize: Int = 0,
    StatusFont: Int = 0,
    SpacerPadding: Int = 0,
    StatusText: String = "",
    rowPadding: Int = 10,
    rowStartPadding: Int = 11,


    ) {
    Row(
        modifier
            .padding(rowPadding.dp)
            .padding(start = rowStartPadding.dp), Arrangement.Center
    ) {

        Icon(
            painterResource(id = IconId),
            contentDescription = contentDescription,
            modifier.size(IconSize.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = title,
            color = TextColor,
            fontSize = FontSize.sp,
            modifier = modifier.padding(start = TextPadding.dp)
        )
        Spacer(modifier = Modifier.padding(end = SpacerPadding.dp))
        Text(
            text = StatusText,
            color = StatusColor,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(2.dp)
                .padding(5.dp)
        )

    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    homeListBox(rememberNavController())

}
