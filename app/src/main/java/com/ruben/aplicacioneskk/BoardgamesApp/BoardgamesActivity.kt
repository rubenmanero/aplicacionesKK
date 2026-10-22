package com.ruben.aplicacioneskk.BoardgamesApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ruben.aplicacioneskk.BoardgamesApp.GameCategory.*
import com.ruben.aplicacioneskk.R

class BoardgamesActivity : AppCompatActivity() {

    private val categories: List<GameCategory> = listOf(Cooperative, Deckbuilding, Euro, LCG, Legacy)
    private val games: MutableList<Game> = mutableListOf(
        Game("Frostpunk", Cooperative),
        Game("Hero Realm", Deckbuilding),
        Game("Arkham Horror", LCG),
        Game("Caverna", Euro),
        Game("Gloomhaven", Legacy),
        Game("Leyendas de Andor", Cooperative),
        Game("Marvel Champions", LCG),
        Game("Everdell", Euro),
        Game("Aeon's End", Deckbuilding)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var fabAddGame: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boardgames)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListeners()
        initUI()
    }

    private fun initListeners() {
        fabAddGame.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)

        val etGame = dialog.findViewById<EditText>(R.id.etGame)
        val rgCategories = dialog.findViewById<RadioGroup>(R.id.rgCategories)
        val btnAddGame = dialog.findViewById<Button>(R.id.btnAddGame)

        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if(currentGame.isNotBlank()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)

                val currentCategory: GameCategory = when(selectedRadioButton.text) {
                    getString(R.string.dialog_cooperative_category) -> Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> Deckbuilding
                    getString(R.string.dialog_euro_category) -> Euro
                    getString(R.string.dialog_lcg_category) -> LCG
                    else -> Legacy
                }
                games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()
            }
        }

        dialog.show()

    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        gamesAdapter = GamesAdapter(games)
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGames.adapter = gamesAdapter
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvGames = findViewById(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)
    }
}