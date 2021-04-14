package kr.hyunwoo.recyclerviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.hyunwoo.recyclerviewsample.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityName = intent.getStringExtra("city") ?: "ERROR"
        binding.txtCityName.text = cityName
    }
}