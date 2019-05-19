package org.uhworks.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_product.*
import org.uhworks.coderswag.Adapters.ProductRecycleAdapter
import org.uhworks.coderswag.R
import org.uhworks.coderswag.Services.DataService
import org.uhworks.coderswag.Utilities.*

class ProductActivity : AppCompatActivity() {

    private lateinit var adapter: ProductRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        // Unpack the extra
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        println(categoryType)

        // Adapter
        adapter = ProductRecycleAdapter(this, DataService.getProductList(categoryType)) { product ->
            // Create intent
            val productDetailsIntent = Intent(this, ProductDetailActivity::class.java)

            // Send product as extra parcelable object
            productDetailsIntent.putExtra(EXTRA_PRODUCT, product)

            // Start activity
            startActivity(productDetailsIntent)

        }
        productListView.adapter = adapter

        // Change the number of cells depending on the screen orientation
        var spanCount = DEFAULT_SPAN_COUNT

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = LANDSCAPE_SPAN_COUNT
        }
        if (resources.configuration.screenWidthDp > BIG_SCREEN_MIN_SIZE) {
            spanCount = BIG_SCREEN_SPAN_COUNT
        }

        // Layout Manager
        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager

        // Add click listener
        productListView.setOnClickListener { }
    }
}
