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

// OBSOLETE: Used with ListView and not needed with RecyclerView
class CategoryAdapter(private val context: Context, private val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val categoryView: View
        val holderView: ViewHolder

        // If the view is not existent
        if (convertView == null) {

            // LayoutInflater is an object takes an XML layout and returns it as a view
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holderView = ViewHolder()

            // Create UI elements based on the IDs found on the categoryListItems
            holderView.categoryImage = categoryView.findViewById(R.id.categoryImg)
            holderView.categoryName = categoryView.findViewById(R.id.categoryName)

            // Set the tag
            categoryView.tag = holderView

        } else {

            holderView = convertView.tag as ViewHolder
            categoryView = convertView

        }

        // Set the values to the UI
        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holderView.categoryName?.text = category.title
        holderView.categoryImage?.setImageResource(resourceId)

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

    private class ViewHolder {

        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}