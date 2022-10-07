package br.infnet.edu.listadecompras.model

import android.text.Editable

//String instead of Editable?
data class ItemCompra(val nome: String, val quant: String) {
    override fun toString(): String {
        return "${quant} x ${nome}"
    }
}