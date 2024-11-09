package com.hero.z_market.ui.screen.home

import android.graphics.Typeface
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.ui.ChildCategoryGoodsListActivity
import com.hero.z_market.ui.MainActivity.Companion.PARENT_CATEGORY
import com.hero.z_market.ui.screen.parentCategory.ParentCategoryListScreen
import com.hero.z_market.ui.viewmodel.MainViewModel

@Composable
fun HomeScreen(mainViewModel: MainViewModel) {
    val uiState by mainViewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (uiState) {
            is MainViewModel.UiState.FetchParentCategoryListSuccess -> {
                ParentCategoryListScreen(
                    parentCategoryList = (uiState as MainViewModel.UiState.FetchParentCategoryListSuccess).value,
                    onClicked = { parentCategory ->
                        val intent =
                            ChildCategoryGoodsListActivity.getIntent(context, parentCategory)
                                .apply {
                                    putExtra(PARENT_CATEGORY, parentCategory)
                                }
                        context.startActivity(intent)
                    }
                )
            }

            is MainViewModel.UiState.FetchParentCategoryListFailed -> {
                Toast.makeText(context, "데이터를 불러오는 데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            is MainViewModel.UiState.Idle -> {}
        }

        Text(
            modifier = Modifier.padding(20.dp, 50.dp, 0.dp, 0.dp),
            text = "기획전 / 이벤트",
            fontSize = 15.sp,
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h2,
            color = Color.Black,
        )
    }
}
