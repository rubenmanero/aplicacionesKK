package com.ruben.aplicacioneskk.BoardgamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacioneskk.R

class GamesAdapter(private val games: List<Game>): RecyclerView.Adapter<GamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent,false)
        return GamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GamesViewHolder,position: Int) {
        holder.render(games[position])
    }

    override fun getItemCount() = games.size

}