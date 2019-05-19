package org.uhworks.coderswag.Services

import org.uhworks.coderswag.Model.Category
import org.uhworks.coderswag.Model.Product

object DataService {

    val categories = listOf(
        Category("DIGITAL", "digitalgoodsimage"),
        Category("HATS", "hatimage"),
        Category("HOODIES", "hoodieimage"),
        Category("SHIRTS", "shirtimage")
    )

    val hats = listOf(
        Product("Devslopes Graphic Beanie", "$18", "hat1"),
        Product("Devslopes Hat Black", "$20", "hat2"),
        Product("Devslopes Hat White", "$18", "hat3"),
        Product("Devslopes Hat Snapback", "$22", "hat4")
    )

    val hoodies = listOf(
        Product("Devslopes Hoodie Grey", "$28", "hoodie1"),
        Product("Devslopes Hoodie Red", "$32", "hoodie2"),
        Product("Devslopes Grey Hoodie", "$28", "hoodie3"),
        Product("Devslopes Hoodie Black", "$32", "hoodie4")
    )

    val shirts = listOf(
        Product("Devslopes Shirt Black", "$18", "shirt1"),
        Product("Devslopes Badge Light Grey", "$20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "$22", "shirt3"),
        Product("Devslopes Hustle", "$22", "shirt4"),
        Product("Kickflip Studios", "$18", "shirt5")
    )

    val digitalgoods = listOf<Product>()

    fun getProductList(category: String): List<Product> {

        return when (category) {

            "HATS" -> hats
            "SHIRTS" -> shirts
            "HOODIES" -> hoodies
            else -> digitalgoods
        }
    }
}