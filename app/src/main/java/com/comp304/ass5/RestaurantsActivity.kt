package com.comp304.ass5

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import java.util.Locale
import com.comp304.ass5.food.CuisineContent
import com.comp304.ass5.food.CuisineType
import com.comp304.ass5.food.Restaurant

import kotlinx.android.synthetic.main.activity_restaurants.*

class RestaurantsActivity : AppCompatActivity() {

    private var _cuisineContent: CuisineContent? = null
    private var _jeoCoder: Geocoder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        this._cuisineContent = CuisineContent
        this._jeoCoder = Geocoder(baseContext, Locale.getDefault())

        this.populateRestaurantListView(cuisineType = this.intent.extras!!.get("cuisine") as CuisineType)

        lvRestaurants.onItemClickListener =
                AdapterView.OnItemClickListener { _, view, position, _ ->
                    val restaurantSelected: Restaurant =
                            lvRestaurants.getItemAtPosition(position) as Restaurant
                    val address = this._jeoCoder!!.getFromLocationName(restaurantSelected.address, 1)

                    startActivity(
                            Intent(view.context, MapsActivity::class.java)
                                    .putExtra("address", address[0])
                                    .putExtra("restaurant", restaurantSelected)
                    )
                }
    }

    private fun populateRestaurantListView(cuisineType: CuisineType) {
        lvRestaurants.adapter = ArrayAdapter<Restaurant>(
                this,
                android.R.layout.simple_list_item_1,
                this._cuisineContent!!.CuisineMap.get(cuisineType)
        )
    }
}
