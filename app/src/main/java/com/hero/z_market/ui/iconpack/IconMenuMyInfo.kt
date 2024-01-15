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
fun rememberIconMenuMyInfo(): ImageVector {
    return remember {
        ImageVector.Builder(
                name = "IconMenuMyInfo",
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
    				strokeLineCap = StrokeCap.Butt,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(16.34f, 7.60092f)
					arcTo(4.1f, 4.1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 12.24f, 11.70092f)
					arcTo(4.1f, 4.1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.14f, 7.60092f)
					arcTo(4.1f, 4.1f, 0f, isMoreThanHalf = false, isPositiveArc = true, 16.34f, 7.60092f)
					close()
}
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
					moveTo(20.525f, 20.9456f)
					curveTo(20.525f, 17.3558f, 16.8075f, 14.4456f, 11.975f, 14.4456f)
					curveTo(7.1425f, 14.4456f, 3.475f, 17.3558f, 3.475f, 20.9456f)
}
}.build()
    }
}

