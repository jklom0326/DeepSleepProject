package com.example.safaud20.alarm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.safaud20.R

class ListAdapter internal constructor(context: Context) : RecyclerView.Adapter<com.example.safaud20.alarm.ListAdapter.timeViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var times = emptyList<alramData>() // Cached copy of words

    inner class timeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.item_list_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): timeViewHolder {
        val itemView = inflater.inflate(R.layout.item_list, parent, false)
        return timeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: timeViewHolder, position: Int) {
        val current = times[position]
        holder.wordItemView.text = current.time
    }

    internal fun settimes(words: List<alramData>) {
        this.times = words
        notifyDataSetChanged()
    }

   override fun getItemCount() = times.size

}