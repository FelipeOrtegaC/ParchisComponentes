package com.serpientesescaleras.parchiscomponentes

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.serpientesescaleras.parchiscomponentes.Model.Fichas
import com.serpientesescaleras.parchiscomponentes.Model.Jugador
import com.serpientesescaleras.parchiscomponentes.Model.TableroMap
import com.serpientesescaleras.parchiscomponentes.Model.TipoCasilla
import kotlin.random.Random

//import com.google.firebase.Firebase

class BoardActivity : AppCompatActivity() {
    private val mapa = mutableListOf<TableroMap>()
    private val fichas = mutableListOf<Fichas>()
    private val jugadores = mutableListOf<Jugador>()
    private var Resultado: Int = 0
    private var Resultado2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_activity)
        val home: ImageButton = findViewById(R.id.btnReturn)

        //Tomamos los nombres de los jugadores
        var txtNombre1: TextView = findViewById(R.id.txtJugador1)
        var txtNombre2: TextView = findViewById(R.id.txtJugador2)

        val name1: String? = intent.getStringExtra("Nombre1")
        val name2: String = "Felipe"

        if (name1 != null){
            jugadores.add(Jugador(1,name1, true, "GREEN"))
            txtNombre1.text = "Jugador:\n"+name1
        }else{
            jugadores.add(Jugador(1,"Jugador 1", true, "GREEN"))
            txtNombre1.text = "Jugador:\n"+ "Jugador 1"
        }

        jugadores.add(Jugador(2, name2, false, "BLUE"))
        txtNombre2.text = "Jugador:\n"+name2

        //Activamos el mapeo del tablero
        activeMap()

        val btnLanzar: Button = findViewById(R.id.botonDado)
        var intento: Int = 1
        var par: Int = 1
        var txtToast: TextView = findViewById(R.id.txtGanador)

        btnLanzar.setOnClickListener {
            val Dado = Random
            val Dado2 = Random
            Resultado = Dado.nextInt(6) + 1
            Resultado2 = Dado2.nextInt(6) + 1
            val txtDado1: TextView = findViewById(R.id.dado)
            val txtDado2: TextView = findViewById(R.id.dadodos)

            txtDado1.text = Resultado.toString()
            txtDado2.text = Resultado2.toString()

            if (Resultado == 5 && Resultado2 == 5 && fichas[0].Posicion == 0 && fichas[1].Posicion == 0 && jugadores[0].turno == true){
                fichas[0].PosAnterior = fichas[0].Celda
                fichas[0].Posicion = 56
                actualizarVistaFichaEnCasilla(0,0,56)

                fichas[1].PosAnterior = fichas[1].Celda
                fichas[1].Posicion = 56
                actualizarVistaFichaEnCasilla(0,1,56)


                jugadores[0].turno == false
                jugadores[1].turno == true
                txtToast.text = "Turno: "+jugadores[1].nombre
            } else if (Resultado == 5 && Resultado2 == 5 && fichas[2].Posicion == 0 && fichas[3].Posicion == 0 && jugadores[1].turno == true){
                fichas[2].PosAnterior = fichas[2].Celda
                fichas[2].Posicion = 22
                actualizarVistaFichaEnCasilla(1,2,22)

                fichas[3].PosAnterior = fichas[3].Celda
                fichas[3].Posicion = 22
                actualizarVistaFichaEnCasilla(1,3,22)




                jugadores[1].turno == false
                jugadores[0].turno == true
                txtToast.text = "Turno: "+jugadores[0].nombre
            } else {
                if (jugadores[0].turno == true && fichas[0].Posicion == fichas[0].Celda && fichas[1].Posicion == fichas[1].Celda){
                    jugadores[0].turno == false
                    jugadores[1].turno == true
                    txtToast.text = "Turno: "+jugadores[1].nombre
                } else if (jugadores[1].turno == true && fichas[2].Posicion == fichas[2].Celda && fichas[3].Posicion == fichas[3].Celda){
                    jugadores[1].turno == false
                    jugadores[0].turno == true
                    txtToast.text = "Turno: "+jugadores[0].nombre
                }
            }
        }

        val btnF1 : Button = findViewById(R.id.btnFicha1)
        val btnF2 : Button = findViewById(R.id.btnFicha2)



        btnF1.setOnClickListener{
            if (jugadores[0].turno == true){
                if(Resultado == Resultado2 && fichas[0].Posicion != 0){
                    fichas[0].PosAnterior = fichas[0].Posicion
                    fichas[0].Posicion = fichas[0].Posicion + Resultado + Resultado2
                    actualizarVistaFichaEnCasilla(0,0,fichas[0].Posicion)
                } else {
                    if (Resultado != 0){
                        fichas[0].PosAnterior = fichas[0].Posicion
                        fichas[0].Posicion = fichas[0].Posicion + Resultado
                        actualizarVistaFichaEnCasilla(0,0,fichas[0].Posicion)
                        Resultado = 0
                    }else if (Resultado2 != 0){
                        fichas[0].PosAnterior = fichas[0].Posicion
                        fichas[0].Posicion = fichas[0].Posicion + Resultado2
                        actualizarVistaFichaEnCasilla(0,0,fichas[0].Posicion)
                    }
                }

                jugadores[0].turno == false
                jugadores[1].turno == true
                txtToast.text = "Turno: "+jugadores[1].nombre
            }else if(jugadores[1].turno == true){
                if(Resultado == Resultado2 && fichas[2].Posicion != 0){
                    fichas[2].PosAnterior = fichas[2].Posicion
                    fichas[2].Posicion = fichas[2].Posicion + Resultado + Resultado2
                    actualizarVistaFichaEnCasilla(1,2,fichas[2].Posicion)
                } else {
                    if (Resultado != 0){
                        fichas[2].PosAnterior = fichas[2].Posicion
                        fichas[2].Posicion = fichas[2].Posicion + Resultado
                        actualizarVistaFichaEnCasilla(1,2,fichas[2].Posicion)
                        Resultado = 0
                    }else if (Resultado2 != 0){
                        fichas[2].PosAnterior = fichas[2].Posicion
                        fichas[2].Posicion = fichas[2].Posicion + Resultado2
                        actualizarVistaFichaEnCasilla(1,2,fichas[2].Posicion)
                    }
                }

                jugadores[1].turno == false
                jugadores[0].turno == true
                txtToast.text = "Turno: "+jugadores[0].nombre
            }
        }

        btnF2.setOnClickListener{
            if (jugadores[0].turno == true){
                if(Resultado == Resultado2 && fichas[1].Posicion != 0){
                    fichas[1].PosAnterior = fichas[1].Posicion
                    fichas[1].Posicion = fichas[1].Posicion + Resultado + Resultado2
                    actualizarVistaFichaEnCasilla(0,1,fichas[1].Posicion)
                    if (fichas[1].Posicion == fichas [2].Posicion){

                    } else if (fichas[1].Posicion == fichas[3].Posicion){

                    }
                } else {
                    if (Resultado != 0){
                        fichas[1].PosAnterior = fichas[1].Posicion
                        fichas[1].Posicion = fichas[1].Posicion + Resultado
                        actualizarVistaFichaEnCasilla(0,1,fichas[1].Posicion)
                        Resultado = 0
                    }else if (Resultado2 != 0){
                        fichas[1].PosAnterior = fichas[1].Posicion
                        fichas[1].Posicion = fichas[1].Posicion + Resultado2
                        actualizarVistaFichaEnCasilla(0,1,fichas[1].Posicion)
                    }
                }
                jugadores[0].turno == false
                jugadores[1].turno == true
                txtToast.text = "Turno: "+jugadores[1].nombre
            }else if(jugadores[1].turno == true){
                if(Resultado == Resultado2 && fichas[3].Posicion != 0){
                    fichas[3].PosAnterior = fichas[3].Posicion
                    fichas[3].Posicion = fichas[3].Posicion + Resultado + Resultado2
                    actualizarVistaFichaEnCasilla(1,3,fichas[3].Posicion)
                } else {
                    if (Resultado != 0){
                        fichas[3].PosAnterior = fichas[3].Posicion
                        fichas[3].Posicion = fichas[3].Posicion + Resultado
                        actualizarVistaFichaEnCasilla(1,3,fichas[3].Posicion)
                        Resultado = 0

                    } else if (Resultado2 != 0){
                        fichas[3].PosAnterior = fichas[3].Posicion
                        fichas[3].Posicion = fichas[3].Posicion + Resultado2
                        actualizarVistaFichaEnCasilla(1,3,fichas[3].Posicion)
                    }
                }

                jugadores[1].turno == false
                jugadores[0].turno == true
                txtToast.text = "Turno: "+jugadores[0].nombre
            }
        }

        home.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    //Realiza los movimientos en el tablero
    private fun actualizarVistaFichaEnCasilla(jugadorIndex: Int, fichaIndex: Int, nuevaPosicion: Int) {
        val jugador = jugadores[jugadorIndex]
        val ficha = fichas[fichaIndex]

        // Encuentra la casilla en el mapa correspondiente a la nueva posición
        var casilla = mapa.find { it.numero == nuevaPosicion }

        // Asegúrate de que la casilla no sea nula (puede ocurrir si la posición no está en el mapa)
        if (casilla != null) {
            // Actualiza la vista de la casilla según el tipo de casilla
            when (casilla.Tipo) {
                TipoCasilla.CELDA -> {
                    if (casilla.casilla.text == "O") {
                        if (ficha.PosAnterior == ficha.Celda) {
                            casilla = mapa.find { it.numero == ficha.PosAnterior }
                            if (casilla != null) {
                                casilla.casilla.text = ""
                            }
                            casilla = mapa.find { it.numero == nuevaPosicion }
                            if (casilla != null) {
                                casilla.casilla.text = "OO"
                            }
                            if (casilla != null) {
                                casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                            }
                        }else{
                            casilla = mapa.find { it.numero == ficha.PosAnterior }
                            if (casilla != null) {
                                casilla.casilla.text = ""
                            }
                            casilla = mapa.find { it.numero == nuevaPosicion }
                            if (casilla != null) {
                                casilla.casilla.text = "OO"
                            }
                            if (casilla != null) {
                                casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                            }
                        }
                    }else{
                        if (ficha.PosAnterior == ficha.Celda) {
                            casilla = mapa.find { it.numero == ficha.PosAnterior }
                            if (casilla != null) {
                                casilla.casilla.text = ""
                            }
                            casilla = mapa.find { it.numero == nuevaPosicion }
                            if (casilla != null) {
                                casilla.casilla.text = "O"
                            }
                            if (casilla != null) {
                                casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                            }
                        }else{
                            casilla = mapa.find { it.numero == ficha.PosAnterior }
                            if (casilla != null) {
                                casilla.casilla.text = ""
                            }
                            casilla = mapa.find { it.numero == nuevaPosicion }
                            if (casilla != null) {
                                casilla.casilla.text = "O"
                            }
                            if (casilla != null) {
                                casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                            }
                        }
                    }

                }
                TipoCasilla.SALIDA_VERDE, TipoCasilla.SALIDA_AZUL -> {
                    if (casilla.casilla.text == "O") {
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "OO"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }else{
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "O"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }
                }
                TipoCasilla.SEGURO -> {
                    if (casilla.casilla.text == "O") {
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "OO"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }else{
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "O"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }
                }
                TipoCasilla.NORMAL->{
                    if (casilla.casilla.text == "O") {
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "OO"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }else{
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "O"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }
                }
                TipoCasilla.SUBIDA_VERDE, TipoCasilla.SUBIDA_AZUL -> {

                }
                TipoCasilla.CAMINO -> {
                    if (casilla.casilla.text == "O") {
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "OO"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }else{
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "O"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }
                }
                TipoCasilla.GANADOR_VERDE, TipoCasilla.GANADOR_AZUL -> {
                    if (casilla.casilla.text == "O") {
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "OO"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }else{
                        casilla = mapa.find { it.numero == ficha.PosAnterior }
                        if (casilla != null) {
                            casilla.casilla.text = ""
                        }
                        casilla = mapa.find { it.numero == nuevaPosicion }
                        if (casilla != null) {
                            casilla.casilla.text = "O"
                        }
                        if (casilla != null) {
                            casilla.casilla.setTextColor(Color.parseColor(jugador.Team))
                        }
                    }
                }
            }
        }
    }

    fun activeMap(){
        //Fichas generadas en sus respecivas celdas
        fichas.add(Fichas(1, "GREEN",501, 0,501))
        fichas.add(Fichas(2, "GREEN",502, 0,502))
        fichas.add(Fichas(1, "BLUE",503, 0,503))
        fichas.add(Fichas(2, "BLUE",504, 0,504))

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

    }
}

