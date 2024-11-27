package com.hero.z_market.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hero.z_market.R
import com.hero.z_market.ui.theme.Gray800
import com.hero.z_market.ui.theme.ZMarketTheme
import com.hero.z_market.ui.utils.KoreanExtension.setPostPosition
import com.hero.z_market.ui.utils.ToastExtension.PutIntoCartToast

object ToastExtension {
    @Composable
    fun PutIntoCartToast(
        goodsName: String,
        modifier: Modifier = Modifier,
        backgroundColor: Color = Gray800,
        textColor: Color = White,
    ) {
        val oldMessage = "${goodsName.setPostPosition("을", "를")} 장바구니에 담았습니다."
        var newMessage = remember { mutableStateOf(oldMessage) }

        Snackbar(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(16.dp),
            containerColor = backgroundColor
        ) {
            Row(
                modifier = modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_green_check),
                        contentDescription = "Successfully put into cart",
                        tint = Unspecified,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = newMessage.value,
                    color = textColor,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    onTextLayout = { text ->
                        if (text.lineCount > 1) {
                            // 텍스트가 1줄을 초과하면 `${goods}를` 뒤에 개행 추가
                            newMessage.value =
                                "${goodsName.setPostPosition("을", "를")}\n장바구니에 담았습니다."
                        }
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomToastPreview() {
    ZMarketTheme {
        PutIntoCartToast(
            goodsName = "LA갈비 세트",
        )
    }
}
