package com.example.gmaillist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(private val items: List<ItemModel>): BaseAdapter() {
    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View

        // Use ViewHolder pattern for better performance
        val viewHolder: ViewHolder

        if (convertView == null) {
            // Inflate the layout for each item
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.custom_item_view, parent, false)
            viewHolder = ViewHolder(
                itemView.findViewById(R.id.itemImage),
                itemView.findViewById(R.id.itemTitle),
                itemView.findViewById(R.id.itemContent),
                itemView.findViewById(R.id.itemTime)
            )
            itemView.tag = viewHolder // Store the view holder in the tag
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder // Retrieve the view holder
        }

        // Get the current item
        val currentItem = getItem(position) as ItemModel

        // Bind data to views
        viewHolder.imageView.setImageResource(currentItem.imageId)
        viewHolder.titleTextView.text = currentItem.title
        viewHolder.contentTextView.text = currentItem.content
        viewHolder.timeTextView.text = currentItem.time

        return itemView
    }

    // ViewHolder class to hold references to views for better performance
    private class ViewHolder(
        val imageView: ImageView,
        val titleTextView: TextView,
        val contentTextView: TextView,
        val timeTextView: TextView
    )
}