package com.ruben.aplicacioneskk.BoardgamesApp

data class Game (val name: String, val category: GameCategory, var isSelected: Boolean = false)