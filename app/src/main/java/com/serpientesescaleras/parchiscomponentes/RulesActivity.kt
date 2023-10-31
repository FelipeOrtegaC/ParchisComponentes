package com.serpientesescaleras.parchiscomponentes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rules_activity)
        val btn: Button = findViewById(R.id.backbutton)
        btn.setOnClickListener {val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}