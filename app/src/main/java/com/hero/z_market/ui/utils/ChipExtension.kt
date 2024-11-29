package com.hero.z_market.ui.utils

import android.graphics.Typeface
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.R
import com.hero.z_market.ui.theme.ZMarketTheme

@Composable
fun SortChip(
    selected: Boolean,
    onChipClicked: (String, Boolean) -> Unit,
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = RoundedCornerShape(8.dp),
    selectedColor: Color,
    unselectedColor: Color,
    chipTextStyle: TextStyle,
    selectedTextColor: Color,
    unselectedTextColor: Color,
    elevation: SelectableChipElevation? = FilterChipDefaults.filterChipElevation(),
    border: BorderStroke? = FilterChipDefaults.filterChipBorder(enabled, selected),
    interactionSource: MutableInteractionSource? = null,
) {
    Surface(
        color = if (selected) selectedColor else unselectedColor,
        shape = shape,
        modifier = modifier
            .wrapContentSize()
            .clip(shape)
            .clickable { onChipClicked(text, selected) }
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 4.dp), // 고정 높이로 설정
            verticalAlignment = Alignment.CenterVertically, // Row 내 자식 요소 수직 정렬
        ) {
            Icon(
                imageVector = if (selected) {
                    ImageVector.vectorResource(id = R.drawable.icon_selected_order)
                } else {
                    ImageVector.vectorResource(id = R.drawable.icon_unselected_order)
                },
                contentDescription = "Selected icon",
                modifier = Modifier.size(4.dp),
                tint = if (selected) Blue else LightGray
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = text,
                fontSize = 13.sp,
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                color = if (selected) selectedTextColor else unselectedTextColor,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .align(Alignment.CenterVertically), // 수직 중앙 정렬
                style = chipTextStyle,
                maxLines = 1
            )
        }
    }
}


@Composable
fun ChipGroup(
    modifier: Modifier = Modifier,
    chipStateList: List<ChipState>,
    chipStyle: ChipStyle,
    onChipClicked: (String, Boolean, Int) -> Unit,
) {
    LazyRow(modifier = modifier) {
        items(count = chipStateList.size) { index ->
            SortChip(
                modifier = Modifier,
                text = chipStateList[index].labelText,
                selected = chipStateList[index].isSelected.value,
                selectedColor = chipStyle.selectedColor,
                unselectedColor = chipStyle.unselectedColor,
                chipTextStyle = chipStyle.chipTextStyle,
                selectedTextColor = chipStyle.selectedTextColor,
                unselectedTextColor = chipStyle.unselectedTextColor,
                onChipClicked = { label, isSelected ->
                    val chipState = chipStateList[index]
                    if (!chipState.isSelected.value) { // 이미 선택된 Chip이면 무시
                        chipStateList.forEachIndexed { chipIndex, chipState ->
                            chipState.isSelected.value = chipIndex == index
                        }
                        onChipClicked(label, false, index) // 새로운 isSelected 값을 전달
                    }
                }
            )
            Spacer(modifier = Modifier.padding(6.dp))
        }
    }
}

data class ChipState(
    var labelText: String,
    val isSelected: MutableState<Boolean>,
)

data class ChipStyle(
    val selectedColor: Color,
    val unselectedColor: Color,
    val chipTextStyle: TextStyle,
    val selectedTextColor: Color,
    val unselectedTextColor: Color,
    val chipModifier: Modifier = Modifier,
)

@Composable
@Preview(showBackground = true)
fun ChipPreview() {
    ZMarketTheme {
        SortChip(
            modifier = Modifier,
            selected = true,
            onChipClicked = { content, isSelected ->

            },
            text = "낮은가격순",
            enabled = true,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.icon_selected_order),
                    contentDescription = "Selected icon",
                    modifier = Modifier
                        .size(4.dp)
                        .padding(start = 10.dp),
                    tint = Blue
                )
            },
            shape = FilterChipDefaults.shape,
            selectedColor = Transparent,
            unselectedColor = Transparent,
            chipTextStyle = MaterialTheme.typography.bodyMedium,
            selectedTextColor = Black,
            unselectedTextColor = LightGray,
        )
    }
}
