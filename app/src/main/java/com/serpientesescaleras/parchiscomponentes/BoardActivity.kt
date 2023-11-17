package com.serpientesescaleras.parchiscomponentes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.serpientesescaleras.parchiscomponentes.Model.Fichas
import com.serpientesescaleras.parchiscomponentes.Model.TableroMap
import com.serpientesescaleras.parchiscomponentes.Model.TipoCasilla

//import com.google.firebase.Firebase

class BoardActivity : AppCompatActivity() {
    private val mapa = mutableListOf<TableroMap>()
    private val fichas = mutableListOf<Fichas>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_activity)
        val home: ImageButton = findViewById(R.id.btnReturn)

        //Fichas generadas en sus respecivas celdas
        fichas.add(Fichas(1, "Green",0, 501))
        fichas.add(Fichas(2, "Green",0, 502))
        fichas.add(Fichas(1, "Blue",0, 503))
        fichas.add(Fichas(2, "Blue",0, 504))

        //Mapeo de las casillas
        mapa.add(TableroMap(501, TipoCasilla.CELDA, findViewById<TextView>(R.id.casillagreen1)))
        mapa.add(TableroMap(502, TipoCasilla.CELDA, findViewById<TextView>(R.id.casillagreen2)))
        mapa.add(TableroMap(503, TipoCasilla.CELDA, findViewById<TextView>(R.id.casillablue1)))
        mapa.add(TableroMap(504, TipoCasilla.CELDA, findViewById<TextView>(R.id.casillablue2)))

        //Mapeo casillas de salida
        mapa.add(TableroMap(56, TipoCasilla.SALIDA_VERDE, findViewById<TextView>(R.id.casilla56)))
        mapa.add(TableroMap(22, TipoCasilla.SALIDA_AZUL, findViewById<TextView>(R.id.casilla22)))

        //Mapeo casillas de seguro, camino hacia la meta y normales
        mapa.add(TableroMap(57, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla57)))
        mapa.add(TableroMap(58, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla58)))
        mapa.add(TableroMap(59, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla59)))
        mapa.add(TableroMap(60, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla60)))
        mapa.add(TableroMap(61, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla61)))
        mapa.add(TableroMap(62, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla62)))
        mapa.add(TableroMap(63, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla63)))
        mapa.add(TableroMap(64, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla64)))
        mapa.add(TableroMap(65, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla65)))
        mapa.add(TableroMap(66, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla66)))
        mapa.add(TableroMap(67, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla67)))
        mapa.add(TableroMap(68, TipoCasilla.SEGURO , findViewById<TextView>(R.id.casilla68)))
        mapa.add(TableroMap(1, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla1)))
        mapa.add(TableroMap(2, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla2)))
        mapa.add(TableroMap(3, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla3)))
        mapa.add(TableroMap(4, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla4)))
        mapa.add(TableroMap(5, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla5)))
        mapa.add(TableroMap(6, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla6)))
        mapa.add(TableroMap(7, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla7)))
        mapa.add(TableroMap(8, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla8)))
        mapa.add(TableroMap(9, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla9)))
        mapa.add(TableroMap(10, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla10)))
        mapa.add(TableroMap(11, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla11)))
        mapa.add(TableroMap(12, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla12)))
        mapa.add(TableroMap(13, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla13)))
        mapa.add(TableroMap(14, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla14)))
        mapa.add(TableroMap(15, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla15)))
        mapa.add(TableroMap(16, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla16)))
        mapa.add(TableroMap(17, TipoCasilla.SUBIDA_AZUL, findViewById<TextView>(R.id.casilla17)))
        mapa.add(TableroMap(18, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla18)))
        mapa.add(TableroMap(19, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla19)))
        mapa.add(TableroMap(20, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla20)))
        mapa.add(TableroMap(21, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla21)))
        mapa.add(TableroMap(23, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla23)))
        mapa.add(TableroMap(24, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla24)))
        mapa.add(TableroMap(25, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla25)))
        mapa.add(TableroMap(26, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla26)))
        mapa.add(TableroMap(27, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla27)))
        mapa.add(TableroMap(28, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla28)))
        mapa.add(TableroMap(29, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla29)))
        mapa.add(TableroMap(30, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla30)))
        mapa.add(TableroMap(31, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla31)))
        mapa.add(TableroMap(32, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla32)))
        mapa.add(TableroMap(33, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla33)))
        mapa.add(TableroMap(34, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla34)))
        mapa.add(TableroMap(35, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla35)))
        mapa.add(TableroMap(36, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla36)))
        mapa.add(TableroMap(37, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla37)))
        mapa.add(TableroMap(38, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla38)))
        mapa.add(TableroMap(39, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla39)))
        mapa.add(TableroMap(40, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla40)))
        mapa.add(TableroMap(41, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla41)))
        mapa.add(TableroMap(42, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla42)))
        mapa.add(TableroMap(43, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla43)))
        mapa.add(TableroMap(44, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla44)))
        mapa.add(TableroMap(45, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla45)))
        mapa.add(TableroMap(46, TipoCasilla.SEGURO, findViewById<TextView>(R.id.casilla46)))
        mapa.add(TableroMap(47, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla47)))
        mapa.add(TableroMap(48, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla48)))
        mapa.add(TableroMap(49, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla49)))
        mapa.add(TableroMap(50, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla50)))
        mapa.add(TableroMap(51, TipoCasilla.SUBIDA_VERDE, findViewById<TextView>(R.id.casilla51)))
        mapa.add(TableroMap(52, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla52)))
        mapa.add(TableroMap(53, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla53)))
        mapa.add(TableroMap(54, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla54)))
        mapa.add(TableroMap(55, TipoCasilla.NORMAL, findViewById<TextView>(R.id.casilla55)))

        //Mapeo del camino a la meta de cada jugador: Sumarle cien en el codigo para conceder el acceso a estos caminos
        mapa.add(TableroMap(151, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw1)))
        mapa.add(TableroMap(152, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw2)))
        mapa.add(TableroMap(153, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw3)))
        mapa.add(TableroMap(154, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw4)))
        mapa.add(TableroMap(155, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw5)))
        mapa.add(TableroMap(156, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw6)))
        mapa.add(TableroMap(157, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillagw7)))

        mapa.add(TableroMap(117, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw1)))
        mapa.add(TableroMap(118, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw2)))
        mapa.add(TableroMap(119, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw3)))
        mapa.add(TableroMap(120, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw4)))
        mapa.add(TableroMap(121, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw5)))
        mapa.add(TableroMap(122, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw6)))
        mapa.add(TableroMap(123, TipoCasilla.CAMINO, findViewById<TextView>(R.id.casillabw7)))

        //Mapeo de las casillas ganadoras
        mapa.add(TableroMap(158, TipoCasilla.GANADOR_VERDE, findViewById<TextView>(R.id.casillagwinner)))
        mapa.add(TableroMap(124, TipoCasilla.GANADOR_AZUL, findViewById<TextView>(R.id.casillabwinner)))

        home.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}