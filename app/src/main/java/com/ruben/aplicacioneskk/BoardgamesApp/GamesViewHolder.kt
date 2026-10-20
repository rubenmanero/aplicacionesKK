package com.ruben.aplicacioneskk.BoardgamesApp

import android.content.res.ColorStateList
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ruben.aplicacioneskk.R

class GamesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvGame: TextView = view.findViewById(R.id.tvGame)
    val cbGame: CheckBox = view.findViewById(R.id.cbGame)

    fun render(game: Game) {
        tvGame.text = game.name

        val color = when(game.category){
            GameCategory.Cooperative -> R.color.bgapp_cooperative_category
            GameCategory.Deckbuilding -> R.color.bgapp_deckbuilding_category
            GameCategory.Euro -> R.color.bgapp_euro_category
            GameCategory.LCG -> R.color.bgapp_lcg_category
            GameCategory.Legacy -> R.color.bgapp_legacy_category
        }

        cbGame.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbGame.context, color))
    }

}