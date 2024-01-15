package com.hero.z_market.ui.iconpack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


@Composable
fun rememberIconMenuFavorites(): ImageVector {
    return remember {
        ImageVector.Builder(
                name = "IconMenuFavorites",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
				path(
    				fill = null,
    				fillAlpha = 1.0f,
    				stroke = SolidColor(Color(0xFF707683)),
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 2f,
    				strokeLineCap = StrokeCap.Round,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(17.3176f, 13.8853f)
					lineTo(18.0652f, 14.5495f)
					lineTo(17.3176f, 13.8853f)
					curveTo(16.9473f, 14.3021f, 16.7678f, 14.8546f, 16.8224f, 15.4094f)
					lineTo(17.3035f, 20.2996f)
					lineTo(12.8013f, 18.3309f)
					curveTo(12.2904f, 18.1076f, 11.7096f, 18.1076f, 11.1987f, 18.3309f)
					lineTo(6.69654f, 20.2996f)
					lineTo(7.17758f, 15.4094f)
					curveTo(7.2322f, 14.8546f, 7.0526f, 14.3021f, 6.6824f, 13.8853f)
					lineTo(3.41882f, 10.2118f)
					lineTo(8.2183f, 9.15815f)
					lineTo(8.00388f, 8.18141f)
					lineTo(8.21831f, 9.15815f)
					curveTo(8.7629f, 9.0386f, 9.2328f, 8.6972f, 9.5148f, 8.2162f)
					lineTo(12f, 3.97721f)
					lineTo(14.4852f, 8.2162f)
					curveTo(14.7672f, 8.6972f, 15.2371f, 9.0386f, 15.7817f, 9.1581f)
					lineTo(20.5812f, 10.2118f)
					lineTo(17.3176f, 13.8853f)
					close()
}
}.build()
    }
}

