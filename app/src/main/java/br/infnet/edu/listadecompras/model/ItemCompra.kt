package br.infnet.edu.listadecompras.model

import android.text.Editable

data class ItemCompra(
    val nome: String,
    val quant: String) {
    override fun toString(): String {
        return "${quant} x ${nome}"
    }
}