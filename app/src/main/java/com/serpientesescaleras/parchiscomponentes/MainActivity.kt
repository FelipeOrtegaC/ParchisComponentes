package com.serpientesescaleras.parchiscomponentes

import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Locale

class MainActivity : AppCompatActivity() {
  private val database: DatabaseReference = Firebase.database("https://parchiscomponentes-default-rtdb.firebaseio.com/").reference.child("partidas")
  override fun onCreate(savedInstanceState: Bundle?) {

      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)
      var txtName1 = findViewById<TextView>(R.id.etxtPplayer)
      var txtSala = findViewById<TextView>(R.id.etxtSplayer)

      val btn: Button = findViewById(R.id.btnStart)
      val info: Button = findViewById(R.id.btnInfo)

      btn.setOnClickListener {
          val name = txtName1.text.toString()
          val intent: Intent = Intent(this, BoardActivity::class.java)
          intent.putExtra("Nombre1",name)
          startActivity(intent)
      }

      /*
      btn.setOnClickListener {
          val name = txtName1.text.toString()
          val Key = txtSala.text.toString()
          

          val intent: Intent = Intent(this, LoadActivity::class.java)
          startActivity(intent)
      }
      */

      info.setOnClickListener {
      val intent: Intent = Intent(this, RulesActivity::class.java)
      startActivity(intent)
      }

  }
}

