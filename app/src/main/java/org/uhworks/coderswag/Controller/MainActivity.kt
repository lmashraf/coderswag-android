package org.uhworks.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.uhworks.coderswag.Model.Category
import org.uhworks.coderswag.R
import org.uhworks.coderswag.Services.DataService

class MainActivity : AppCompatActivity() {

    // Create an adapter to serve the data to the listview
    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,        // Context
            android.R.layout.simple_list_item_1,    // Default view
            DataService.categories)                 // Source of data

        categoryListView.adapter = adapter
    }
}
