package com.example.login_compose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController



    @Composable
    fun HomeScreen(navController: NavController) {

        Spacer(modifier = Modifier)
        Box(
            modifier = Modifier
                .padding(20.dp)
                .padding(top = 50.dp)
                .border(1.dp, Color.Black)
                .height(300.dp)
                .fillMaxWidth()
                .background(Color.Gray)

        ) {
            Column() {

                Row(Modifier.padding(20.dp)) {
                    Text(text = "Project Name : "+ "Afton", fontSize = 18.sp)
                    Spacer(modifier = Modifier.padding(end = 100.dp))
                    Text(
                        text = "Status : Pending",
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Text(
                    text = "Notification@ :     9:00pm",
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(20.dp)
                )

                Text(
                    text = "Next In line      :     Binish",
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(20.dp)
                )

            }
        }
    }


    @Preview
    @Composable
    fun HomeScreenPreview() {
        HomeScreen(rememberNavController())
    }
