package kr.hyunwoo.recyclerviewsample

import android.app.Application

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initPixelUtil()
    }

    private fun initPixelUtil() {
        pixelRatio = PixelRatio(this)
    }

    companion object {
        lateinit var pixelRatio: PixelRatio
    }
}