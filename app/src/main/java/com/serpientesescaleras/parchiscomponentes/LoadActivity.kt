package com.serpientesescaleras.parchiscomponentes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class LoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_activity)

        val videoView: VideoView = findViewById(R.id.videoUp)

        // Puedes poner un archivo de video en la carpeta res/raw y obtener su URI
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.carga )

        // Configura el MediaController para permitir la reproducción, pausa, etc.
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Establece la URI del video y comienza la reproducción
        videoView.setVideoURI(videoUri)

        videoView.setOnCompletionListener { mp ->
            // El video ha terminado, reinicia la reproducción
            videoView.start()
        }

        videoView.start()
    }
}