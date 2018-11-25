package assignment5.comp304.josephharrisonlimkevinma.labassignment5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineType

class CuisineActivity : AppCompatActivity() {
    var bundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bundle = savedInstanceState

        setContentView(R.layout.activity_cuisine)

        when (bundle!!.getString("cuisine")) {
            CuisineType.American.name -> {

            }
            CuisineType.Asian.name -> {

            }
            CuisineType.Breakfast.name -> {

            }
            CuisineType.Chinese.name -> {

            }
            CuisineType.Indian.name -> {

            }
            CuisineType.Italian.name -> {

            }
        }
    }
}
