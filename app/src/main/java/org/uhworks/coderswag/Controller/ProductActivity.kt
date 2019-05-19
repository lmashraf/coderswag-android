package org.uhworks.coderswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        adapter = ProductRecycleAdapter(this, DataService.getProductList(categoryType))
        productListView.adapter = adapter

        // Change the number of cells depending on the screen orientation
        var spanCount: Int

        spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            LANDSCAPE_SPAN_COUNT else DEFAULT_SPAN_COUNT

        spanCount =
            if (resources.configuration.screenWidthDp > BIG_SCREEN_MIN_SIZE) BIG_SCREEN_SPAN_COUNT else DEFAULT_SPAN_COUNT

        // Layout Manager
        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
    }
}
