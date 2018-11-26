package assignment5.comp304.josephharrisonlimkevinma.labassignment5

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineContent
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineType

class CuisinesListActivity : AppCompatActivity() {

    private var _cuisineContent: CuisineContent? = null
    private var _cuisinesListListView: ListView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuisines_list)

        this._cuisineContent = CuisineContent
        this._cuisinesListListView = findViewById(R.id.cuisine_list_listview)

        //set adapter for listview
        this._cuisinesListListView!!.adapter = ArrayAdapter<CuisineType>(
            this, android.R.layout.simple_list_item_1, this._cuisineContent!!.Cuisines
        )

        //attach event handlers
        this._cuisinesListListView!!.onItemClickListener =
                AdapterView.OnItemClickListener { _, view, position, _ ->
                    val cuisineSelected = this._cuisinesListListView!!.getItemAtPosition(position) as CuisineType
                    startActivity(
                        Intent(view.context, RestaurantsListActivity::class.java).putExtra(
                            "cuisine", cuisineSelected
                        )
                    )
                }
    }
}
