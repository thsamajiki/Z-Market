package com.hero.z_market.ui.screen.childCategory

import android.graphics.Typeface
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.data.response.PaginationItem

@Composable
fun PaginationInfoScreen(
    pagination: PaginationItem,
) {
    Row(
        modifier = Modifier.padding(start = 20.dp, top = 30.dp),
    ) {
        Text(
            text = pagination.totalElements.toString(),
            fontSize = 13.sp,
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
            color = Black,
        )
        Text(
            modifier = Modifier.padding(start = 0.5.dp),
            text = "건의 검색결과",
            fontSize = 13.sp,
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
            color = Black,
        )
    }
}
