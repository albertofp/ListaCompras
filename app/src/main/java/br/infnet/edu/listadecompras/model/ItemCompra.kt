package br.infnet.edu.listadecompras.model

import android.text.Editable

//String instead of Editable?
data class ItemCompra(val nome: Editable, val quant: Editable) {
    override fun toString(): String {
        return "${quant} x ${nome}"
    }
}