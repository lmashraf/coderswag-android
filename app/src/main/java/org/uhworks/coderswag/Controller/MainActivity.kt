package org.uhworks.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.uhworks.coderswag.Adapters.CategoryRecycleAdapter
import org.uhworks.coderswag.R
import org.uhworks.coderswag.Services.DataService
import org.uhworks.coderswag.Utilities.EXTRA_CATEGORY

class MainActivity : AppCompatActivity() {

    // Create an adapter to serve the data to the listview
    private lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            // Create intent
            val productIntent = Intent(this, ProductActivity::class.java)

            // Use extra to send category name
            productIntent.putExtra(EXTRA_CATEGORY, category.title)

            // Go to next screen
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        // Create layout manager for the RecyclerView
        val layoutManager = LinearLayoutManager(this)

        categoryListView.layoutManager = layoutManager
        //categoryListView.setHasFixedSize(true)

        // Create own listener
        categoryListView.setOnClickListener { }
    }
}
