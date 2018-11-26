package assignment5.comp304.josephharrisonlimkevinma.labassignment5.food

import java.util.HashMap

object CuisineContent {

    val Cuisines: MutableList<CuisineType> = mutableListOf(
        CuisineType.American,
        CuisineType.Asian,
        CuisineType.Breakfast,
        CuisineType.Chinese,
        CuisineType.Indian,
        CuisineType.Italian
    )
//    val Cuisines: MutableList<String> = mutableListOf("American", "Asian", "Breakfast", "Chinese", "Indian", "Italian")

    val CuisineMap: MutableMap<CuisineType, MutableList<Restaurant>> = HashMap()

    init {
        CuisineMap.putAll(Restaurant.american())
        CuisineMap.putAll(Restaurant.asian())
    }
}
