package assignment5.comp304.josephharrisonlimkevinma.labassignment5

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import assignment5.comp304.josephharrisonlimkevinma.labassignment5.food.CuisineType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //attach event handlers
        findViewById<Button>(R.id.main_continue_btn).setOnClickListener {
            run {
                Toast.makeText(
                    this, resources.getString(R.string.main_continue_btn_clicked_txt), Toast.LENGTH_LONG
                ).show()
                startActivity(Intent(this, CuisinesListActivity::class.java))
            }
        }
//        findViewById<Button>(R.id.main_continue_btn).setOnClickListener { view -> this.onContinueBtnClick(view) }
    }

    fun onContinueBtnClick(view: View?) {

        Toast.makeText(this, resources.getString(R.string.main_continue_btn_clicked_txt), Toast.LENGTH_LONG).show()

        fun startCuisineActivity(cuisineType: CuisineType) {
            val b = Bundle()
            b.putString("cuisine", cuisineType.name)
            startActivity(Intent(this, RestaurantsListActivity::class.java).putExtras(b))
//            startActivity(Intent(this, CuisineActivity::class.java).putExtras(b))
        }
//
//        when (view!!.id) {
//            startAmericanBtn.id -> startCuisineActivity(CuisineType.American)
//            startAsianBtn.id -> startCuisineActivity(CuisineType.Asian)
//        }
    }
}
