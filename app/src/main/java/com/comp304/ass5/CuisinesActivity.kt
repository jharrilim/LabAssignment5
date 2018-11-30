package com.comp304.ass5

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.comp304.ass5.food.CuisineContent
import com.comp304.ass5.food.CuisineType

import kotlinx.android.synthetic.main.activity_cuisines.*

class CuisinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuisines)

        lvCuisines.adapter = ArrayAdapter<CuisineType>(
                this, android.R.layout.simple_list_item_1, CuisineContent.Cuisines
        )

        lvCuisines.onItemClickListener = AdapterView.OnItemClickListener { _, view, position, _ ->
            val cuisineSelected = lvCuisines.getItemAtPosition(position) as CuisineType
            startActivity(
                    Intent(view.context, RestaurantsListActivity::class.java).putExtra(
                            "cuisine", cuisineSelected
                    )
            )
        }
    }
}
