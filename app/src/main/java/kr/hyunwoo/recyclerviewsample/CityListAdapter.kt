package kr.hyunwoo.recyclerviewsample

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.hyunwoo.recyclerviewsample.databinding.ItemCityInfoBinding

class CityListAdapter : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {
    private var cityList = mutableListOf<City>()

    class ViewHolder(private val binding: ItemCityInfoBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(city: City) {
            binding.txtCityName.text = city.name
            binding.txtCityCountry.text = city.country
            binding.root.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("city", city.name)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCityInfoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(cityList[position])
    }

    override fun getItemCount() = cityList.size

    fun replaceList(newCityList: List<City>) {
        cityList = newCityList.toMutableList()
        notifyDataSetChanged()
    }

}