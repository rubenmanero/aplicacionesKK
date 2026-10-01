package com.ruben.aplicacioneskk.MessageApp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.ruben.aplicacioneskk.R

class ReplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reply)



        val rootView = findViewById<View>(R.id.main) // tu ConstraintLayout raíz

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom

            // Sube el contenedor del EditText la altura del teclado
            view.setPadding(
                view.paddingLeft,
                view.paddingTop,
                view.paddingRight,
                maxOf(imeHeight, navBarHeight)
            )
            insets
        }

        // Necesario para que el listener reciba los insets del teclado
        WindowCompat.setDecorFitsSystemWindows(window, false)


        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnSend = findViewById<Button>(R.id.btnSend)
        val etMessage = findViewById<EditText>(R.id.etMessage)

        var msg = intent.extras?.getString("extra_message").orEmpty()
        tvMessage.text = msg
        tvTitle.text = "Message received!"

        btnSend.setOnClickListener {
            var message: String = etMessage.text.toString()
            if(message.isNotBlank()){
                var intent = Intent(this, MessageActivity::class.java)
                intent.putExtra("extra_message",message)
                startActivity(intent)
            }
        }
    }
}