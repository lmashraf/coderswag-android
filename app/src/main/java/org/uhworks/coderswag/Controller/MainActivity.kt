package org.uhworks.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.uhworks.coderswag.Adapters.CategoryAdapter
import org.uhworks.coderswag.Model.Category
import org.uhworks.coderswag.R
import org.uhworks.coderswag.Services.DataService

class MainActivity : AppCompatActivity() {

    // Create an adapter to serve the data to the listview
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        categoryListView.adapter = adapter
    }
}
