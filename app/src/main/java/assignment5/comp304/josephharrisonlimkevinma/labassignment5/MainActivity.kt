package assignment5.comp304.josephharrisonlimkevinma.labassignment5

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onMenuBtnClick(view: View?) {

        fun startCuisineActivity(cuisineType: CuisineType) {
            val b = Bundle()
            b.putString("cuisine", cuisineType.name)
            startActivity(Intent(this, RestaurantsListActivity::class.java).putExtras(b))
//            startActivity(Intent(this, CuisineActivity::class.java).putExtras(b))
        }

        when (view!!.id) {
            startAmericanBtn.id -> startCuisineActivity(CuisineType.American)
            startAsianBtn.id -> startCuisineActivity(CuisineType.Asian)
        }
    }
}
