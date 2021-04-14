package kr.hyunwoo.recyclerviewsample

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kr.hyunwoo.recyclerviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cityList = City.getCityList()
        val cityListAdapter = CityListAdapter()
        binding.rvMainCity.adapter = cityListAdapter
        binding.rvMainCity.setHasFixedSize(true)
        binding.rvMainCity.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom = 12.dp
            }
        })
        cityListAdapter.replaceList(cityList)
    }
}