package br.infnet.edu.listadecompras.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel():ViewModel() {

    private val _listaItems = mutableListOf<ItemCompra>()

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