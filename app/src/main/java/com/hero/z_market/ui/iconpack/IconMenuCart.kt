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
fun rememberIconMenuCart(): ImageVector {
    return remember {
        ImageVector.Builder(
                name = "IconMenuCart",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
				path(
    				fill = SolidColor(Color(0xFF707683)),
    				fillAlpha = 1.0f,
    				stroke = null,
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 1.0f,
    				strokeLineCap = StrokeCap.Butt,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.EvenOdd
				) {
					moveTo(2.68066f, 3f)
					curveTo(2.1284f, 3f, 1.6807f, 3.4477f, 1.6807f, 4f)
					curveTo(1.6807f, 4.5523f, 2.1284f, 5f, 2.6807f, 5f)
					horizontalLineTo(4.07976f)
					verticalLineTo(7.03414f)
					curveTo(4.0798f, 7.0521f, 4.0802f, 7.07f, 4.0812f, 7.0877f)
					curveTo(4.0803f, 7.1067f, 4.0798f, 7.1258f, 4.0798f, 7.145f)
					verticalLineTo(15.8957f)
					curveTo(4.0798f, 16.5584f, 4.6171f, 17.0957f, 5.2798f, 17.0957f)
					horizontalLineTo(19.02f)
					curveTo(19.5915f, 17.0957f, 20.0837f, 16.6927f, 20.1964f, 16.1324f)
					lineTo(21.6805f, 8.75592f)
					curveTo(21.8214f, 8.0558f, 21.3233f, 7.3883f, 20.612f, 7.3241f)
					lineTo(6.07976f, 6.01237f)
					verticalLineTo(4.29774f)
					curveTo(6.0798f, 3.581f, 5.4988f, 3f, 4.782f, 3f)
					horizontalLineTo(2.68066f)
					close()
					moveTo(6.07983f, 15.0957f)
					verticalLineTo(8.02051f)
					lineTo(19.5439f, 9.23581f)
					lineTo(18.3649f, 15.0957f)
					horizontalLineTo(6.07983f)
					close()
}
				path(
    				fill = SolidColor(Color(0xFF707683)),
    				fillAlpha = 1.0f,
    				stroke = null,
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 1.0f,
    				strokeLineCap = StrokeCap.Butt,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(9.16906f, 20.488f)
					curveTo(9.1691f, 21.5526f, 8.306f, 22.4157f, 7.2414f, 22.4157f)
					curveTo(6.1768f, 22.4157f, 5.3137f, 21.5526f, 5.3137f, 20.488f)
					curveTo(5.3137f, 19.4234f, 6.1768f, 18.5603f, 7.2414f, 18.5603f)
					curveTo(8.306f, 18.5603f, 9.1691f, 19.4234f, 9.1691f, 20.488f)
					close()
}
				path(
    				fill = SolidColor(Color(0xFF707683)),
    				fillAlpha = 1.0f,
    				stroke = null,
    				strokeAlpha = 1.0f,
    				strokeLineWidth = 1.0f,
    				strokeLineCap = StrokeCap.Butt,
    				strokeLineJoin = StrokeJoin.Miter,
    				strokeLineMiter = 1.0f,
    				pathFillType = PathFillType.NonZero
				) {
					moveTo(16.6806f, 22.4157f)
					curveTo(17.7452f, 22.4157f, 18.6083f, 21.5526f, 18.6083f, 20.488f)
					curveTo(18.6083f, 19.4234f, 17.7452f, 18.5603f, 16.6806f, 18.5603f)
					curveTo(15.616f, 18.5603f, 14.7529f, 19.4234f, 14.7529f, 20.488f)
					curveTo(14.7529f, 21.5526f, 15.616f, 22.4157f, 16.6806f, 22.4157f)
					close()
}
}.build()
    }
}

