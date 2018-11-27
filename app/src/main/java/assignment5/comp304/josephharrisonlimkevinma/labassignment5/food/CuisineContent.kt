package assignment5.comp304.josephharrisonlimkevinma.labassignment5.food

import java.util.*

object CuisineContent {

    val Cuisines: MutableList<CuisineType> = mutableListOf(
        CuisineType.American,
        CuisineType.Asian,
        CuisineType.Breakfast,
        CuisineType.Chinese,
        CuisineType.Indian,
        CuisineType.Italian
    )

    val CuisineMap: MutableMap<CuisineType, MutableList<Restaurant>> = HashMap()

    init {
        CuisineMap.putAll(Restaurant.american())
        CuisineMap.putAll(Restaurant.asian())
        CuisineMap.putAll(Restaurant.breakfast())
        CuisineMap.putAll(Restaurant.chinese())
        CuisineMap.putAll(Restaurant.indian())
        CuisineMap.putAll(Restaurant.italian())
    }
}
