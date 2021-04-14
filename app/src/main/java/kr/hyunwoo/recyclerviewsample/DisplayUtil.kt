package kr.hyunwoo.recyclerviewsample

import android.app.Application
import androidx.annotation.Px
import kotlin.math.roundToInt

class PixelRatio(private val app: Application) {
    private val displayMetrics
        get() = app.resources.displayMetrics

    val screenWidth
        get() = displayMetrics.widthPixels

    val screenHeight
        get() = displayMetrics.heightPixels

    val screenShort
        get() = screenWidth.coerceAtMost(screenHeight)

    val screenLong
        get() = screenWidth.coerceAtLeast(screenHeight)

    @Px
    fun toPixel(dp: Int) = (dp * displayMetrics.density).roundToInt()

    fun toDP(@Px pixel: Int) = (pixel / displayMetrics.density).roundToInt()
}

val Number.pixel: Int
    @Px get() = SampleApp.pixelRatio.toDP(this.toInt())

val Number.dp: Int
    get() = SampleApp.pixelRatio.toPixel(this.toInt())

val Number.pixelFloat: Float
    @Px get() = SampleApp.pixelRatio.toDP(this.toInt()).toFloat()

val Number.dpFloat: Float
    get() = SampleApp.pixelRatio.toPixel(this.toInt()).toFloat()