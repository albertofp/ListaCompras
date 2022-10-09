package br.infnet.edu.listadecompras.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.infnet.edu.listadecompras.R
import br.infnet.edu.listadecompras.model.ItemCompra

class RecyclerAdapter(private var _itemsList: MutableList<ItemCompra>)
            : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

        init {
            Log.d("RecyclerAdapter","RecyclerAdapter initialized")
            Log.d("itemList size","${_itemsList.size}")
        }
        inner class ItemViewHolder(itemView : View):
            RecyclerView.ViewHolder(itemView){
            val nomeTextView: TextView  = itemView.findViewById(R.id.itemNome)
            val nomeTextNumber: TextView= itemView.findViewById(R.id.itemQuant)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val itemView = LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.list_item,parent,false)
            Log.d("onCreateViewHolder()","RecyclerAdapter.onCreateViewHolder() called")

            return ItemViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RecyclerAdapter.ItemViewHolder, position: Int) {
            holder.nomeTextView.text = _itemsList[position].nome
            holder.nomeTextNumber.text = _itemsList[position].quant

            Log.d("onBindViewHolder()","called")
            Log.d("onBindViewHolder()","${holder.nomeTextView.text}")
        }

        override fun getItemCount(): Int { return _itemsList.size  }
    }
