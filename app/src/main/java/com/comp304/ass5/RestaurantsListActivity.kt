package com.comp304.ass5

import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import com.comp304.ass5.food.CuisineContent
import com.comp304.ass5.food.CuisineType
import com.comp304.ass5.food.Restaurant
import java.util.*

class RestaurantsListActivity : AppCompatActivity() {

    private var _bundle: Bundle? = null
    private var _cuisineContent: CuisineContent? = null
    private var _cuisineTypeSpinner: Spinner? = null
    private var _restaurantsListListView: ListView? = null
    private var _geocoder: Geocoder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants_list)

        this._bundle = this.intent.extras
        this._cuisineContent = CuisineContent
        this._cuisineTypeSpinner = findViewById(R.id.cuisine_type_spinner)
        this._restaurantsListListView = findViewById(R.id.restaurant_list_listview)
        this._geocoder = Geocoder(baseContext, Locale.getDefault())

        this._cuisineTypeSpinner!!.adapter = ArrayAdapter<CuisineType>(
            this, android.R.layout.simple_spinner_dropdown_item, this._cuisineContent!!.Cuisines
        )

        this._populateRestaurantListView(cuisineType = this._bundle!!.get("cuisine") as CuisineType)

        //attache event handlers
        findViewById<Button>(R.id.rest_list_show_btn).setOnClickListener {
            this._showBtnClicked()
        }

        this._restaurantsListListView!!.onItemClickListener =
                AdapterView.OnItemClickListener { _, view, position, _ ->
                    val restaurantSelected: Restaurant =
                        this._restaurantsListListView!!.getItemAtPosition(position) as Restaurant
                    val address = this._geocoder!!.getFromLocationName(restaurantSelected.address, 1)

                    Toast.makeText(
                        this,
                        "You have selected ${restaurantSelected.name}!",
                        Toast.LENGTH_LONG
                    ).show()

                    startActivity(
                        Intent(view.context, MapsActivity::class.java)
                            .putExtra("address", address[0])
                            .putExtra("restaurant", restaurantSelected)
                    )

                }
    }

    private fun _showBtnClicked() {
        var selectedCuisineType: CuisineType =
            findViewById<Spinner>(R.id.cuisine_type_spinner).selectedItem as CuisineType

        this._populateRestaurantListView(cuisineType = selectedCuisineType)
    }

    private fun _populateRestaurantListView(cuisineType: CuisineType) {
        //update ctrls with appropiate data
        this._cuisineTypeSpinner!!.setSelection(cuisineType.ordinal)
        this._restaurantsListListView!!.adapter = ArrayAdapter<Restaurant>(
            this,
            android.R.layout.simple_list_item_1,
            this._cuisineContent!!.CuisineMap.get(cuisineType)
        )

        //provide feedback to users upon cuisine type selection made
        when (cuisineType) {
            CuisineType.American -> Toast.makeText(
                this,
                resources.getString(R.string.restaurant_list_american_sel_txt),
                Toast.LENGTH_SHORT
            )
                .show()
            CuisineType.Asian -> Toast.makeText(
                this,
                resources.getString(R.string.restaurant_list_asian_sel_txt),
                Toast.LENGTH_SHORT
            )
                .show()
            CuisineType.Breakfast -> Toast.makeText(
                this,
                resources.getString(R.string.restaurant_list_breakfast_sel_txt),
                Toast.LENGTH_SHORT
            ).show()
            CuisineType.Chinese -> Toast.makeText(
                this,
                resources.getString(R.string.restaurant_list_chinese_sel_txt),
                Toast.LENGTH_SHORT
            )
                .show()
            CuisineType.Indian -> Toast.makeText(
                this,
                resources.getString(R.string.restaurant_list_indian_sel_txt),
                Toast.LENGTH_SHORT
            )
                .show()
            CuisineType.Italian -> Toast.makeText(
                this,
                resources.getString(R.string.restaurant_list_italian_sel_txt),
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }
}
