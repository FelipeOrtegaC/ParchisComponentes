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
          import java.util.Locale

          class MainActivity : AppCompatActivity() {
              override fun onCreate(savedInstanceState: Bundle?) {

                  super.onCreate(savedInstanceState)
                  setContentView(R.layout.activity_main)
                  var txtName1 = findViewById<TextView>(R.id.etxtPplayer)
                  var txtName2 = findViewById<TextView>(R.id.etxtSplayer)

                  val btn: Button = findViewById(R.id.btnStart)
                  val info: Button = findViewById(R.id.btnInfo)
                  btn.setOnClickListener {
                      val name1 = txtName1.text.toString()
                      val name2 = txtName2.text.toString()
                      val intent: Intent = Intent(this, BoardActivity::class.java)
                      intent.putExtra("Nombre1", name1)
                      intent.putExtra("Nombre2", name2)
                      startActivity(intent)
                  }
                  info.setOnClickListener {
                  val intent: Intent = Intent(this, RulesActivity::class.java)
                  startActivity(intent)
                  }
              }
          }

