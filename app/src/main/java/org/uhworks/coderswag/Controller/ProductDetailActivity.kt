package org.uhworks.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.product_list_item.*
import org.uhworks.coderswag.Model.Product
import org.uhworks.coderswag.R
import org.uhworks.coderswag.Utilities.EXTRA_PRODUCT

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceId = resources.getIdentifier(product.image, "drawable", packageName)
        productImage.setImageResource(resourceId)
        productName.text = product.title
        productPrice.text = product.price
    }
}
