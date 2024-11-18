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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.data.response.PaginationItem
import com.hero.z_market.ui.theme.ZMarketTheme

@Composable
fun PaginationInfoScreen(
    pagination: PaginationItem,
) {
    Row(
        modifier = Modifier.padding(start = 20.dp),
    ) {
        Text(
            modifier = Modifier.alignByBaseline(),
            text = pagination.totalElements.toString(),
            fontSize = 13.sp,
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
            color = Black,
        )
        Text(
            modifier = Modifier.alignByBaseline().padding(start = 0.5.dp),
            text = "건의 검색결과",
            fontSize = 13.sp,
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.bodyMedium,
            color = Black,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PaginationInfoScreenPreview() {
    ZMarketTheme {
        PaginationInfoScreen(PaginationItem(0, 20, 20, 1))
    }
}