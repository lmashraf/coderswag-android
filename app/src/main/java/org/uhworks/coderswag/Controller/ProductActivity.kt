package org.uhworks.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.uhworks.coderswag.R
import org.uhworks.coderswag.Utilities.EXTRA_CATEGORY

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        // Unpack the extra
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)

        Toast.makeText(this, "You clicked on the $categoryType category!", Toast.LENGTH_SHORT).show()
    }
}
