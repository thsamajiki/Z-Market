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
fun rememberIconMenuHome(): ImageVector {
    return remember {
        ImageVector.Builder(
                name = "IconMenuHome",
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
					moveTo(12.9159f, 3.26152f)
					curveTo(12.3395f, 2.7378f, 11.4581f, 2.7423f, 10.8871f, 3.272f)
					lineTo(2.00744f, 11.5086f)
					curveTo(1.6025f, 11.8842f, 1.5788f, 12.5169f, 1.9544f, 12.9219f)
					curveTo(2.3299f, 13.3268f, 2.9627f, 13.3505f, 3.3676f, 12.9749f)
					lineTo(3.37735f, 12.9659f)
					verticalLineTo(19.7859f)
					curveTo(3.3773f, 20.9655f, 4.3336f, 21.9218f, 5.5132f, 21.9218f)
					horizontalLineTo(9.55762f)
					curveTo(10.1099f, 21.9218f, 10.5576f, 21.474f, 10.5576f, 20.9218f)
					verticalLineTo(15.3111f)
					horizontalLineTo(13.1925f)
					verticalLineTo(20.9218f)
					curveTo(13.1925f, 21.474f, 13.6402f, 21.9218f, 14.1925f, 21.9218f)
					horizontalLineTo(18.2369f)
					curveTo(19.4165f, 21.9218f, 20.3728f, 20.9655f, 20.3728f, 19.7859f)
					verticalLineTo(12.7391f)
					lineTo(20.64f, 12.9819f)
					curveTo(21.0488f, 13.3533f, 21.6812f, 13.323f, 22.0526f, 12.9143f)
					curveTo(22.424f, 12.5055f, 22.3937f, 11.8731f, 21.985f, 11.5017f)
					lineTo(12.9159f, 3.26152f)
					close()
					moveTo(5.37735f, 19.7859f)
					verticalLineTo(11.136f)
					lineTo(11.875f, 5.17626f)
					lineTo(18.3728f, 11.136f)
					verticalLineTo(19.7859f)
					curveTo(18.3728f, 19.8609f, 18.312f, 19.9218f, 18.2369f, 19.9218f)
					horizontalLineTo(15.1925f)
					verticalLineTo(15.2577f)
					curveTo(15.1925f, 14.1826f, 14.321f, 13.3111f, 13.2459f, 13.3111f)
					horizontalLineTo(10.5042f)
					curveTo(9.4291f, 13.3111f, 8.5576f, 14.1826f, 8.5576f, 15.2577f)
					verticalLineTo(19.9218f)
					horizontalLineTo(5.51324f)
					curveTo(5.4382f, 19.9218f, 5.3773f, 19.8609f, 5.3773f, 19.7859f)
					close()
}
}.build()
    }
}

