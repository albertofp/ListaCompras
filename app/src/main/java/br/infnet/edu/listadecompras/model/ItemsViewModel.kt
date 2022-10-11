package br.infnet.edu.listadecompras.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.infnet.edu.listadecompras.adapter.RecyclerAdapter

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

        fun emptyList(){
            if(_listaItems.size > 0){
                for(item in _listaItems){
                    _listaItems.remove(item)
                }
                _totalItems.value=_listaItems.size
            }
        }

    }