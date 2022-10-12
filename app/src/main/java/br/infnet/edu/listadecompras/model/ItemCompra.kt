package br.infnet.edu.listadecompras.model

data class ItemCompra(
    val nome: String,
    val quant: String
) {
    override fun toString(): String {
        return "$quant x $nome"
    }
}