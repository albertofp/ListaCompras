package br.infnet.edu.listadecompras.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel():ViewModel() {

    private var _listaItems = mutableListOf<ItemCompra>()


    // Retorna a variavel privada contento a lista dos itens
    fun exposeItems(): MutableList<ItemCompra> {
        return _listaItems
    }

    fun addItem(newItem : ItemCompra){
        _listaItems.add(newItem)
    }

    fun delItem(item: ItemCompra){
        _listaItems.remove(item)
    }

    }