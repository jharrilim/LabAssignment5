package assignment5.comp304.josephharrisonlimkevinma.labassignment5

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineType

class CuisineActivity : AppCompatActivity() {
    var bundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        bundle = savedInstanceState
        bundle = this.intent.extras

//        var cuisineType: String = intent.getStringExtra("cuisine") ?: ""
//        Toast.makeText(this, cuisineType, Toast.LENGTH_SHORT).show()

        setContentView(R.layout.activity_cuisine)

        when (bundle!!.getString("cuisine")) {
            CuisineType.American.name -> {
                Toast.makeText(this, "So you want to look at the dirty Americans do ya?", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MapsActivity::class.java))
            }
            CuisineType.Asian.name -> {
                Toast.makeText(this, bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()

            }
            CuisineType.Breakfast.name -> {
                Toast.makeText(this, bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()

            }
            CuisineType.Chinese.name -> {
                Toast.makeText(this, bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()

            }
            CuisineType.Indian.name -> {
                Toast.makeText(this, bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()

            }
            CuisineType.Italian.name -> {
                Toast.makeText(this, bundle!!.getString("cuisine"), Toast.LENGTH_SHORT).show()

            }
        }
    }
}
