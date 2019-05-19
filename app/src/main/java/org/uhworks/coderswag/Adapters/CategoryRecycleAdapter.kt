package org.uhworks.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.uhworks.coderswag.Model.Category
import org.uhworks.coderswag.R

class CategoryRecycleAdapter(
    private val context: Context,
    private val categories: List<Category>,
    private val itemClick: (Category) -> Unit
) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        // Inflate the view for the first time here
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)

        return Holder(inflatedView, itemClick)
    }

    override fun getItemCount(): Int {

        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bindCategory(categories[position], context)
    }

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val categoryImage: ImageView = itemView.findViewById(R.id.categoryImg)
        private val categoryName: TextView = itemView.findViewById(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {

            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title

            // Bind the click to the item through lambda
            itemView.setOnClickListener { itemClick(category) }
        }


    }
}