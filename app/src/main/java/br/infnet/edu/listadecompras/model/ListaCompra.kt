package br.infnet.edu.listadecompras.model

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// data class ListaCompra(var itens: MutableList<ItemCompra> = mutableListOf<ItemCompra>())
class ListaCompra(){
    private val listaItems = mutableListOf<ItemCompra>()
            //private val items      = MutableLiveData<List<ItemCompra>>()
            private val items      = MutableLiveData<List<ItemCompra>>()

    fun addItem(item:ItemCompra){
        listaItems.add(item)
        items.value = listaItems
    }
}