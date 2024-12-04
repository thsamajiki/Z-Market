package com.hero.z_market.ui.screen.category

import android.content.Context
import android.graphics.Typeface
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hero.z_market.domain.entity.ParentCategoryEntity
import com.hero.z_market.ui.ChildCategoryGoodsListActivity
import com.hero.z_market.ui.screen.category.parentCategory.ParentCategoryListScreen
import com.hero.z_market.ui.state.UiEffect
import com.hero.z_market.ui.state.UiState
import com.hero.z_market.ui.viewmodel.MainViewModel

@Composable
fun CategoryListScreen(vm: MainViewModel = hiltViewModel()) {
    val uiState by vm.fetchParentCategoryListUiState.collectAsState()
    val context = LocalContext.current

    val topBarHeight = 48.dp
    val topBarHeightPx = with(LocalDensity.current) { topBarHeight.roundToPx().toFloat() }
    val topBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = topBarOffsetHeightPx.floatValue + delta
                topBarOffsetHeightPx.floatValue = newOffset.coerceIn(-topBarHeightPx, 0f)

                return Offset.Zero
            }
        }
    }

    LaunchedEffect(Unit) {
        vm.handleEvent(MainViewModel.MainUiEvent.FetchParentCategoryList)

        vm.parentCategoryUiEffect.collect { effect ->
            handleUiEffects(effect, context)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        item {
            when (uiState) {
                is UiState.Success<List<ParentCategoryEntity>> -> {
                    val categories = (uiState as UiState.Success<List<ParentCategoryEntity>>).data
                    ParentCategoryListScreen(
                        parentCategoryList = categories,
                        onClicked = { parentCategory ->
                            vm.handleEvent(MainViewModel.MainUiEvent.OnClickParentCategory(parentCategory))
                        }
                    )
                }
                is UiState.Failed -> {}
                is UiState.Idle -> {}
            }
        }

        item {
            Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "기획전 / 이벤트",
                fontSize = 15.sp,
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
        }
    }
}

private fun handleUiEffects(
    effect: UiEffect<ParentCategoryEntity>,
    context: Context
) {
    when (effect) {
        is UiEffect.ShowToast -> {
            Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
        }
        is UiEffect.NavigateTo<ParentCategoryEntity> -> {
            val parentCategory = effect._data
            if (parentCategory != null) {
                val intent = ChildCategoryGoodsListActivity.getIntent(context, parentCategory)
                context.startActivity(intent)
            }
        }
    }
}
