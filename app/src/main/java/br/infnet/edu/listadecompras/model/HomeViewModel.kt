package br.infnet.edu.listadecompras.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    private var _ListaCompra = MutableLiveData<ListaCompra>()
    fun itemlist(): LiveData<ListaCompra>{
        return _ListaCompra
    }

    var itens: LiveData<ListaCompra> = itemlist()

}