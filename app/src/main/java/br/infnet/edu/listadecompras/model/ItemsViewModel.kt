package br.infnet.edu.listadecompras.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel:ViewModel() {

        private var _listaItems = mutableListOf<ItemCompra>()
        private val _totalItems = MutableLiveData<Int>()

        fun totalItems():LiveData<Int>{return _totalItems}

        fun exposeItems(): MutableList<ItemCompra> {return _listaItems}

        fun addItem(newItem : ItemCompra){
            _listaItems.add(newItem)
            _totalItems.value=_listaItems.size
        }

        fun delItem(item: ItemCompra){
            _listaItems.remove(item)
            _totalItems.value=_listaItems.size
        }

    }