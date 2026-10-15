package com.ruben.aplicacioneskk.BoardgamesApp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacioneskk.R

class CategoriesViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)

    fun render (gameCategory: GameCategory) {
        when(gameCategory) {
            GameCategory.Cooperative -> TODO()
            GameCategory.Deckbuilding -> TODO()
            GameCategory.Euro -> TODO()
            GameCategory.LCG -> TODO()
            GameCategory.Legacy -> TODO()
        }
    }
}