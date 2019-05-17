package org.uhworks.coderswag.Services

import org.uhworks.coderswag.Model.Category
import org.uhworks.coderswag.Model.Product

object DataService {

    val categories = listOf(
        Category("DIGITAL","digitalgoodsimage"),
        Category("HATS", "hateimage"),
        Category("HOODIES","hoodieimage"),
        Category("SHIRTS","shirtimage")
    )

    val hats = listOf(
        Product("Devslopes Graphic Beanie","$18", "hat01"),
        Product("Devslopes Hat Black","$20", "hat02"),
        Product("Devslopes Hat White","$18", "hat03"),
        Product("Devslopes Hat Snapback","$22", "hat04")
    )

    val hoodies = listOf(
        Product("Devslopes Hoodie Grey","$28", "hoodie01"),
        Product("Devslopes Hoodie Red","$32", "hoodie02"),
        Product("Devslopes Grey Hoodie","$28", "hoodie03"),
        Product("Devslopes Hoodie Black","$32", "hoodie04")
    )

    val shirts= listOf(
        Product("Devslopes Shirt Black","$18", "shirt01"),
        Product("Devslopes Badge Light Grey","$20", "shirt02"),
        Product("Devslopes Logo Shirt Red","$22", "shirt03"),
        Product("Devslopes Hustle","$22", "shirt04"),
        Product("Kickflip Studios","$18", "shirt05")
    )
}