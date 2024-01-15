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
fun rememberIconMenuCategories(): ImageVector {
    return remember {
        ImageVector.Builder(
                name = "IconMenuCategories",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
				path(
    				fill = null,
    				fillAlpha = 1.0f,
    				stroke = SolidColor(Color(0xFF021245)),
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 2f,
    				strokeLineCap = StrokeCap.Round,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(4f, 7.38f)
					horizontalLineTo(20f)
}
				path(
    				fill = null,
    				fillAlpha = 1.0f,
    				stroke = SolidColor(Color(0xFF021245)),
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 2f,
    				strokeLineCap = StrokeCap.Round,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(4f, 13.38f)
					horizontalLineTo(20f)
}
				path(
    				fill = null,
    				fillAlpha = 1.0f,
    				stroke = SolidColor(Color(0xFF021245)),
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 2f,
    				strokeLineCap = StrokeCap.Round,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(4f, 19.38f)
					horizontalLineTo(20f)
}
}.build()
    }
}

