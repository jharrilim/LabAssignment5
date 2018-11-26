package assignment5.comp304.josephharrisonlimkevinma.labassignment5.food

/**
 * A dummy item representing a piece of content.
 */
data class Restaurant(val name: String, val address: String, val details: String, val cuisineType: CuisineType) {
    override fun toString(): String = "$name\n$address"

    companion object {
        fun american(): MutableMap<CuisineType, MutableList<Restaurant>> {
            return mutableMapOf(
                CuisineType.American to mutableListOf(
                    Restaurant(
                        "McDonalds",
                        "123 Yonge St, Toronto, ON M5C 1W4",
                        "Classic, long-running fast-food chain known for its burgers, fries & shakes.",
                        CuisineType.American
                    ),
                    Restaurant(
                        "The Loose Moose",
                        "146 Front St W, Toronto, ON M5J 1G2",
                        "2nd-floor spot with rustic tables, vintage signs & many beers on tap, plus tacos, burgers & snacks.",
                        CuisineType.American
                    ),
                    Restaurant(
                        "Jack Astor's Bar & Grill",
                        "144 Front St W, Toronto, ON M5J 1G2",
                        "Canadian sports bar with casual dining.",
                        CuisineType.American
                    )
                )
            )
        }

        fun asian(): MutableMap<CuisineType, MutableList<Restaurant>> {
            return mutableMapOf(
                CuisineType.Asian to mutableListOf(
                    Restaurant(
                        "Lee Chen Asian Bistro",
                        "214 King St W, Toronto, ON M5H 3S6",
                        "Roomy restaurant serving Chinese classics, cocktails & draft beer in wood-clad, industrial digs.",
                        CuisineType.Asian
                    ),
                    Restaurant(
                        "Gonoe Sushi",
                        "262 Queens Quay W, Toronto, ON M5J 1B5",
                        "Cozy sushi restaurant by the waterfront.",
                        CuisineType.Asian
                    ),
                    Restaurant(
                        "Asian Bowl",
                        "271 Yonge St, Toronto, ON M5B 1N8",
                        "Informal dining with a menu of popular Pan-Asian dishes, plus drinks in a minimalist, modern space.",
                        CuisineType.Asian
                    )
                )
            )
        }

        //TODO: Add restaurants for Breakfeast, Chinese, Indian, and Italian cuisines
    }
}