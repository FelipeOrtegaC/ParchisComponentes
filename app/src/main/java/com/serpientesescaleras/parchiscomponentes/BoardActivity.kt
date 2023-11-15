package com.serpientesescaleras.parchiscomponentes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase

class BoardActivity : AppCompatActivity() {
    private val db = Firebase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_activity)
        val home: ImageButton = findViewById(R.id.btnReturn)
        home.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}