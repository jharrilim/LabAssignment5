package assignment5.comp304.josephharrisonlimkevinma.labassignment5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.*
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineContent
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineType
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.Restaurant

class RestaurantsListActivity : AppCompatActivity() {

    private var _bundle: Bundle? = null
    private var _cuisineContent: CuisineContent? = null
    private var _selectedCuisineType: CuisineType? = null
    private var _cuisineTypeSpinner: Spinner? = null
    private var _restaurantsListListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants_list)

        this._bundle = this.intent.extras
        this._cuisineContent = CuisineContent
        this._cuisineTypeSpinner = findViewById(R.id.cuisine_type_spinner)
        this._restaurantsListListView = findViewById(R.id.restaurant_list_listview)

        this._cuisineTypeSpinner!!.adapter = ArrayAdapter<CuisineType>(
            this, android.R.layout.simple_spinner_dropdown_item, this._cuisineContent!!.Cuisines
        )

        when (this._bundle!!.getString("cuisine")) {
            CuisineType.American.name -> {
                Toast.makeText(this, "So you want to look at the dirty Americans do ya?", Toast.LENGTH_SHORT).show()
//                startActivity(Intent(this, MapsActivity::class.java))
                this._populateRestaurantListView(CuisineType.American)
            }
            CuisineType.Asian.name -> {
                Toast.makeText(this, this._bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()
                this._populateRestaurantListView(CuisineType.Asian)
            }
            CuisineType.Breakfast.name -> {
                Toast.makeText(this, this._bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()
                this._selectedCuisineType = CuisineType.Breakfast

            }
            CuisineType.Chinese.name -> {
                Toast.makeText(this, this._bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()
                this._selectedCuisineType = CuisineType.Chinese

            }
            CuisineType.Indian.name -> {
                Toast.makeText(this, this._bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()
                this._selectedCuisineType = CuisineType.Indian

            }
            CuisineType.Italian.name -> {
                Toast.makeText(this, this._bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()
                this._selectedCuisineType = CuisineType.Italian

            }
        }

        //attache event handlers
        findViewById<Button>(R.id.rest_list_show_btn).setOnClickListener { view ->
            this.showBtnClicked()
        }
    }

    fun showBtnClicked() {
        var selectedCuisineType: CuisineType =
            findViewById<Spinner>(R.id.cuisine_type_spinner).selectedItem as CuisineType

        this._populateRestaurantListView(selectedCuisineType)
    }

    private fun _populateRestaurantListView(cuisineType: CuisineType) {
        this._selectedCuisineType = cuisineType
        this._cuisineTypeSpinner!!.setSelection(cuisineType.ordinal)
        this._restaurantsListListView!!.adapter = ArrayAdapter<Restaurant>(
            this,
            android.R.layout.simple_list_item_1,
            this._cuisineContent!!.CuisineMap.get(cuisineType)
        )
    }
}
