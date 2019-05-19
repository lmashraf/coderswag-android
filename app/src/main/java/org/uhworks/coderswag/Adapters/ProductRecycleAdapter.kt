package org.uhworks.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.uhworks.coderswag.Model.Product
import org.uhworks.coderswag.R

class ProductRecycleAdapter(
    private val context: Context,
    private val products: List<Product>,
    private val itemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return Holder(inflatedView, itemClick)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bindProduct(products[position], context)
    }

    inner class Holder(itemView: View, val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val productImage: ImageView = itemView.findViewById(R.id.productImage)
        private val productName: TextView = itemView.findViewById(R.id.productName)
        private val productPrice: TextView = itemView.findViewById(R.id.productPrice)

        fun bindProduct(product: Product, context: Context) {

            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)

            productImage.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price

            // Bind the click event
            itemView.setOnClickListener { itemClick(product) }
        }
    }
}