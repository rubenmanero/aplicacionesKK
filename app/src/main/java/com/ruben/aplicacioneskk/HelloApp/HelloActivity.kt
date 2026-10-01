package com.ruben.aplicacioneskk.HelloApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.aplicacioneskk.R

class HelloActivity : AppCompatActivity() {

    private lateinit var tvHello: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hello)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nombre: String? = intent.extras!!.getString("extra_name")
        tvHello = findViewById(R.id.tvHello)
        tvHello.text = "Hola " + nombre + "!"

    }
}