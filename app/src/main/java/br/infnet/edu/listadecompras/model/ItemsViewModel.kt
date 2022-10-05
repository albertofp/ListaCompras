package br.infnet.edu.listadecompras.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel():ViewModel() {
    var lista = ListaCompra()
    /*
        var lista = MutableLiveData<ListaCompra>()
        init {
            lista.value= ListaCompra()
        }
        fun updateLiveData(){

        }
    */
}