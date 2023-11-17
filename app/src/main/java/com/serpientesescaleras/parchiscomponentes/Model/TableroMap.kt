package com.serpientesescaleras.parchiscomponentes.Model

import android.widget.TextView
data class TableroMap (
    val numero: Int,
    val Tipo: TipoCasilla,
    val casilla: TextView
);

data class Fichas (
    val Num_Ficha: Int,
    val Team: String,
    var Posicion: Int,
    var PosAnterior: Int,
    val Celda: Int
);


data class Jugador(
    val id: Int,
    var nombre: String,
    var turno: Boolean,
    val Team: String
)

enum class TipoCasilla{
    CELDA, SEGURO, CAMINO, GANADOR_VERDE, GANADOR_AZUL, SALIDA_VERDE, SALIDA_AZUL, NORMAL, SUBIDA_VERDE, SUBIDA_AZUL
}