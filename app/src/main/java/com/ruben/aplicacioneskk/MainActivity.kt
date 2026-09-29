package com.ruben.aplicacioneskk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnSend: Button
    private lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnSend = findViewById(R.id.btnSend)
        etName = findViewById(R.id.etName)

        btnSend.setOnClickListener {
            var name: String = etName.text.toString()
            if(name.isNotBlank()) {
                var textIntent = Intent(this, HelloActivity::class.java)
                textIntent.putExtra("extra_name",name)
                startActivity(textIntent)
            }
            Log.i("btnSend","Sending")
        }


    }



}