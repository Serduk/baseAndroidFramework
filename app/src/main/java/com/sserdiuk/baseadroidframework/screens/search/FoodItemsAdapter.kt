package com.sserdiuk.baseadroidframework.screens.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sserdiuk.baseadroidframework.R
import com.sserdiuk.baseadroidframework.data.SearchItemModel

class FoodItemsAdapter(val clickListener: ListItemClickListener) :
    RecyclerView.Adapter<FoodItemsAdapter.ViewHolder>() {
    interface ListItemClickListener {
        fun onItemClick(position: Int)
    }

    private var results: List<SearchItemModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.view_item_in_search, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (results.isNullOrEmpty()) return 0
        return results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    fun setItems(newResult: List<SearchItemModel>) {
        results = newResult
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        private var foodImage: ImageView = itemView.findViewById(R.id.itemImage)
        private var name: TextView = itemView.findViewById(R.id.foodName)
        private var quantity: TextView = itemView.findViewById(R.id.quantity)
        private var consist: TextView = itemView.findViewById(R.id.consist)
        private var vendor: TextView = itemView.findViewById(R.id.foodAds)

        fun bind(position: Int) {
            val item: SearchItemModel = results[position]
            name.text = item.name
            consist.text = item.consist
            vendor.text = item.vendor
            quantity.text = item.quantity
            Picasso
                .get()
                .load(item.sImagePath)
                .error(R.drawable.broken_image)
                .placeholder(R.drawable.fastfood)
                .into(foodImage)
        }

        override fun onClick(v: View?) {
            clickListener.onItemClick(adapterPosition)
        }
    }
}