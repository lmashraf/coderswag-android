package org.uhworks.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.uhworks.coderswag.Model.Category
import org.uhworks.coderswag.R

class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {

    private val context = context
    private val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View

        // LayoutInflater is an object takes an XML layout and returns it as a view that can be used in code
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

        // Create UI elements based on the IDs found on the categoryListItems
        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImg)
        val categoryName: TextView = categoryView.findViewById(R.id.categoryName)

        // Set the values to the UI
        val category = categories[position]

        // Set the category name to the textview
        categoryName.text = category.title

        // Set the image to the imageView
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceId)

        println(resourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {

        return categories[position]
    }

    // Defines a unique ID for each row
    override fun getItemId(position: Int): Long {

        // eg.
        // return categories.get(position).id
        // while id is the unique id of an element in the list
        return 0
    }

    override fun getCount(): Int {

        return categories.count()
    }
}