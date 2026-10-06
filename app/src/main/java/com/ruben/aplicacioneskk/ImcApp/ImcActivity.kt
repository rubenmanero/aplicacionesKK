package com.ruben.aplicacioneskk.ImcApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider
import com.ruben.aplicacioneskk.R
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = false
    private var isFemaleSelected: Boolean = true
    private var currentWeight: Int = 70

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight : TextView
    private lateinit var btnSubstractWeight: CardView
    private lateinit var btnAddWeight: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left+32, systemBars.top+32, systemBars.right+32, systemBars.bottom+32)
            insets
        }

        initComponents()
        initListeners()
        setWeight()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setComponentColorMale() }
        viewFemale.setOnClickListener { setComponentColorFemale() }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
        btnSubstractWeight.setOnClickListener {
            currentWeight--
            setWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight++
            setWeight()
        }
    }

    private fun setComponentColorMale() {
        if(!isMaleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }

    private fun setComponentColorFemale() {
        if(!isFemaleSelected) {
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            isMaleSelected = false
            isFemaleSelected = true
        }
    }
}