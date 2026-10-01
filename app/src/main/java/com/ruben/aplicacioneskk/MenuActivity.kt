package com.ruben.aplicacioneskk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.aplicacioneskk.HelloApp.MainActivity
import com.ruben.aplicacioneskk.ImcApp.ImcActivity
import com.ruben.aplicacioneskk.MessageApp.MessageActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener { navigateToHelloApp() }

        var btnMessageApp = findViewById<Button>(R.id.btnMessageApp)
        btnMessageApp.setOnClickListener { navigateToMessageApp() }

        var btnImcApp = findViewById<Button>(R.id.btnImcApp)
        btnImcApp.setOnClickListener { navigateToImcApp() }
    }

    private fun navigateToHelloApp() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMessageApp() {
        var intent = Intent(this, MessageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        var intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }
}