package com.comp304.ass5.food

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A dummy item representing a piece of content.
 */
@Parcelize
data class Restaurant(val name: String, val address: String, val details: String, val cuisineType: CuisineType): Parcelable {
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

        fun breakfast(): MutableMap<CuisineType, MutableList<Restaurant>> {
            return mutableMapOf(
                CuisineType.Breakfast to mutableListOf(
                    Restaurant(
                        "Evviva Breakfast and Lunch",
                        "25 Lower Simcoe St, Toronto, ON M5J 3A1",
                        "Stylish modern breakfast outing with affordable prices",
                        CuisineType.Breakfast
                    ),
                    Restaurant(
                        "Eggspectation",
                        "483 Bay St, Toronto, ON M5G 2C9",
                        "Stylish chain serving a lengthy egg-focused breakfast menu, plus American lunch & dinner fare.",
                        CuisineType.Breakfast
                    ),
                    Restaurant(
                        "Sunset Grill",
                        "205 Wellington St W, Toronto, ON M5V 3G7",
                        "Casual breakfast joint with outdoor seating and vegetarian options.",
                        CuisineType.Breakfast
                    )
                )
            )
        }

        fun chinese(): MutableMap<CuisineType, MutableList<Restaurant>> {
            return mutableMapOf(
                CuisineType.Chinese to mutableListOf(
                    Restaurant(
                        "Hong Shing Chinese Restaurant",
                        "195 Dundas St W, Toronto, ON M5G 1C7",
                        "Happy hour food; Chinese style.",
                        CuisineType.Chinese
                    ),
                    Restaurant(
                        "Yueh Tung Restaurant",
                        "126 Elizabeth St, Toronto, ON M5G 1P5",
                        "Snug eatery specializing in Hakka cuisine, plus an extensive menu of traditional Chinese fare.",
                        CuisineType.Chinese
                    ),
                    Restaurant(
                        "Wah Sing Seafood Restaurant",
                        "47 Baldwin St, Toronto, ON M5T 1L1",
                        "Known for its 2-for-1 lobster special, this bright Chinese seafood spot offers many classic dishes.",
                        CuisineType.Chinese
                    )
                )
            )
        }

        fun indian(): MutableMap<CuisineType, MutableList<Restaurant>> {
            return mutableMapOf(
                CuisineType.Indian to mutableListOf(
                    Restaurant(
                        "Bombay Palace",
                        "71 Jarvis St, Toronto, ON M5C 2H2",
                         "Polished locale for North Indian buffet, plus a small à la carte menu & ample take-out portions.",
                        CuisineType.Indian
                    ),
                    Restaurant(
                        "Aanch",
                        "259 Wellington St W, Toronto, ON M5V 3E4",
                        "Traditional Indian flavours are presented with flair at this intimate eatery with muted decor.",
                        CuisineType.Indian
                    ),
                    Restaurant(
                        "Indian Roti House",
                        "256 Queens Quay W, Toronto, ON M5J 1B5",
                        "Take-out joint serving a menu of meat & vegetarian rotis plus Indian street-food sides & desserts.",
                        CuisineType.Indian
                    )
                )
            )
        }

        fun italian(): MutableMap<CuisineType, MutableList<Restaurant>> {
            return mutableMapOf(
                CuisineType.Italian to mutableListOf(
                    Restaurant(
                        "Fusaro's Italian Kitchen",
                        "147 Spadina Ave, Toronto, ON M5V 2L7",
                        "Snug Italian eatery with a rustic vibe dishes up homestyle pasta, pizza & panini cafeteria-style.\n",
                        CuisineType.Italian
                    ),
                    Restaurant(
                        "Scaddabush Italian Kitchen & Bar",
                        "200 Front St W, Toronto, ON M5V 3J1",
                        "Brick work & elegant touches adorn this Italian kitchen serving fresh pastas & homemade mozzarella.",
                        CuisineType.Italian
                    ),
                    Restaurant(
                        "Trattoria Mercatto",
                        "220 Yonge St, Toronto, ON M5B 2H1",
                        "Sleek space inside the Eaton Centre for classic Italian meals & wine, with big windows & a patio.",
                        CuisineType.Italian
                    )
                )
            )
        }
    }
}