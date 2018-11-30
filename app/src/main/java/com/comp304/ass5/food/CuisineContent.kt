package com.comp304.ass5.food

object CuisineContent {

    val Cuisines: MutableList<CuisineType> = mutableListOf(
            CuisineType.Breakfast,
            CuisineType.Indian,
            CuisineType.Chinese,
            CuisineType.Italian,
            CuisineType.Asian,
            CuisineType.American
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
