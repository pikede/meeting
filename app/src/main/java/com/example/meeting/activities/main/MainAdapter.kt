package com.example.meeting.activities.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meeting.R
import com.example.meeting.models.Sport

class MainAdapter(var listOfSports: List<Sport>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sport_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfSports[position])
    }

    override fun getItemCount() = listOfSports.size

    fun updateSportItems(newListOfSports: List<Sport>){
        listOfSports = newListOfSports
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sport: Sport) {
        }
    }
}