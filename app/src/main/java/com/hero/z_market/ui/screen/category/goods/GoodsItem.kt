package com.hero.z_market.ui.screen.category.goods

import android.graphics.Typeface
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.hero.z_market.R
import com.hero.z_market.constants.BASE_IMG_URL
import com.hero.z_market.domain.entity.GoodsEntity
import com.hero.z_market.ui.preview.goods.GoodsPreviewParameterProvider
import com.hero.z_market.ui.theme.ZMarketTheme
import com.hero.z_market.ui.utils.ModifierExtension.visible
import com.hero.z_market.utils.FormatUtil.formatWithComma

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GoodsItem(
    goods: GoodsEntity,
    modifier: Modifier,
    onClicked: (GoodsEntity) -> Unit,
) {
    val discountedPercent =
        (((goods.salePrice - goods.discountedPrice).toDouble() / goods.salePrice.toDouble()) * 100).toInt()
    var isDiscountedPercentVisible = remember { derivedStateOf { discountedPercent != 0 } }
    val isOutOfOrder = goods.goodsStatus == "일시품절"
    val isSoldOut = goods.goodsStatus == "판매완료"
    val isAdultAuthRequestRequired = goods.adultAuthRequestYesNo == "Y"

    Card(
        modifier = modifier.clickable {  },
        colors = CardDefaults.cardColors(White),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                GlideImage(
                    model = BASE_IMG_URL + goods.imgPath,
                    contentDescription = "goods image"
                )
                Box(
                    modifier = Modifier.fillMaxWidth().height(40.dp)
                        .alpha(0.7f)
                        .align(Alignment.BottomCenter)
                        .visible(isOutOfOrder)
                        .background(Black.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "일시품절",
                        color = White,
                        fontSize = 13.sp,
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth().height(40.dp)
                        .alpha(0.7f)
                        .align(Alignment.BottomCenter)
                        .visible(isSoldOut)
                        .background(Black.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "판매완료",
                        color = White,
                        fontSize = 13.sp,
                    )
                }
                if (isAdultAuthRequestRequired) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(180.dp)
                            .background(Black.copy(alpha = 0.5f))

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_adult_19),
                            modifier = Modifier.align(Alignment.Center),
                            contentDescription = "adult auth request"
                        )
                    }
                }
                if (!isOutOfOrder && !isSoldOut) {
                    Card(
                        modifier = Modifier.wrapContentSize()
                            .padding(end = 10.dp, bottom = 10.dp)
                            .align(Alignment.BottomEnd),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(White),
                        elevation = CardDefaults.cardElevation(4.dp),
                    ) {
                        IconButton(onClick = { onClicked(goods) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_cart_gray),
                                contentDescription = "Put Into Cart",
                                tint = Color(0xFF072363)
                            )
                        }
                    }
                }
            }
        }
        Text(
            text = goods.goodsName,
            modifier =
            if (discountedPercent != 0) Modifier.padding(start = 7.dp, top = 2.dp)
                .align(Alignment.Start)
            else Modifier.padding(start = 9.dp, top = 2.dp)
                .align(Alignment.Start),
            fontFamily = FontFamily(Typeface.SANS_SERIF),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Black,
            fontSize = 13.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        Row(
            modifier = Modifier.padding(start = 7.dp, top = 5.dp)
                .visible(isDiscountedPercentVisible.value),
        ) {
            Text(
                text = formatWithComma(goods.salePrice).toString(),
                modifier = Modifier.alignByBaseline().padding(end = 1.dp),
                textDecoration = if (discountedPercent != 0) TextDecoration.LineThrough else TextDecoration.None,
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Gray,
                fontSize = 11.sp,
                overflow = TextOverflow.Visible,
                maxLines = 1,
            )
            Text(
                text = "원",
                modifier = Modifier.alignByBaseline(),
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Gray,
                fontSize = 11.sp,
                overflow = TextOverflow.Visible,
                maxLines = 1,
            )
        }
        Row(
            modifier = Modifier.padding(start = 7.dp, top = 2.dp)
        ) {
            Text(
                text = discountedPercent.toString(),
                modifier = Modifier.alignByBaseline().visible(isDiscountedPercentVisible.value),
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Red,
                fontSize = 13.sp,
                overflow = TextOverflow.Visible,
                maxLines = 1,
            )
            Text(
                text = "%",
                modifier = Modifier.alignByBaseline().visible(isDiscountedPercentVisible.value),
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Red,
                fontSize = 13.sp,
                overflow = TextOverflow.Visible,
                maxLines = 1,
            )
            Text(
                text = formatWithComma(goods.discountedPrice).toString(),
                modifier =
                if (isDiscountedPercentVisible.value) Modifier.alignByBaseline().padding(start = 5.dp)
                else Modifier.alignByBaseline().padding(start = 4.dp),
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Black,
                fontSize = 13.sp,
                overflow = TextOverflow.Visible,
                maxLines = 1,
            )
            Text(
                text = "원",
                modifier = Modifier.alignByBaseline(),
                fontFamily = FontFamily(Typeface.SANS_SERIF),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Black,
                fontSize = 13.sp,
                overflow = TextOverflow.Visible,
                maxLines = 1,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GoodsItemPreview(
    @PreviewParameter(GoodsPreviewParameterProvider::class)
    goods: GoodsEntity,
) {
    val context = LocalContext.current
    ZMarketTheme {
        GoodsItem(
            goods = goods,
            modifier = Modifier.padding(4.dp),
            onClicked = {
                Toast.makeText(context, "${goods.goodsName} 클릭됨", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
