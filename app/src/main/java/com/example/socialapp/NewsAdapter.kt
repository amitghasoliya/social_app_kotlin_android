package com.example.socialapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter : RecyclerView.Adapter<NewsViewHolder>(){
    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.newsTitle.text = currentItem.title
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.newsImage)
    }

    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()
    }

}
class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    val newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
    val newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
}