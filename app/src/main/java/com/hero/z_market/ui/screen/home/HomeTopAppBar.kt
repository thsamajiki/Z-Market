package com.hero.z_market.ui.screen.home

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.hero.z_market.R
import com.hero.z_market.ui.theme.ZMarketTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar() {
    val context = LocalContext.current

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(White),
        title = {
            Text(
                text = "로그인해주세요",
                fontWeight = FontWeight.Bold // 굵은 글꼴 지정
            )
        },
        actions = {
            IconButton(onClick = { Toast.makeText(context, "개발 예정", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_bell_big),
                    contentDescription = "Notification",
                    tint = Color(0xFF868A93)
                )
            }
            IconButton(onClick = { Toast.makeText(context, "개발 예정", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_setting),
                    contentDescription = "Setting",
                    tint = Color(0xFF868A93)
                )
            }
        })
}

@Composable
@Preview(showBackground = true)
fun MainTopAppBarPreview() {
    ZMarketTheme {
        HomeTopAppBar()
    }
}
