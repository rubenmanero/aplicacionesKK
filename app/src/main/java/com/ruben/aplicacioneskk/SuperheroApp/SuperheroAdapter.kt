package com.ruben.aplicacioneskk.SuperheroApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacioneskk.R

class SuperheroAdapter (var superheroes: List<SuperheroItemResponse> = emptyList()): RecyclerView.Adapter<SuperheroViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperheroViewHolder {
        return SuperheroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(superheroes[position])
    }

    override fun getItemCount() = superheroes.size
}