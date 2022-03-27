package com.example.meeting.activities.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meeting.databinding.SportItemBinding
import com.example.meeting.models.Sport
import com.squareup.picasso.Picasso

class MainAdapter(
    private val context: Context,
    private var listOfSports: List<Sport>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = SportItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfSports[position])
    }

    override fun getItemCount() = listOfSports.size

    fun updateSportItems(newListOfSports: List<Sport>) {
        listOfSports = newListOfSports
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: SportItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sport: Sport) {
            with(binding) {
                sport.name?.let { sportName.text = it }
                sport.format?.let { format.text = it }
                sport.description?.let { teamDescription.text = it }
                sport.thumb?.let {
                    Picasso.get().load(it).fit().into(thumb)
                }
            }
        }
    }
}