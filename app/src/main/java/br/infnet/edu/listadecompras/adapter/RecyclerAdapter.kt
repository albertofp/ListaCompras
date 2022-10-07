package br.infnet.edu.listadecompras.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.infnet.edu.listadecompras.R
import br.infnet.edu.listadecompras.databinding.FragmentAddBinding
import br.infnet.edu.listadecompras.model.ItemCompra
import br.infnet.edu.listadecompras.model.ItemsViewModel
    class RecyclerAdapter(private val _itemsList: List<ItemCompra>) : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

        inner class ItemViewHolder(itemView : View):
            RecyclerView.ViewHolder(itemView){
            val nomeTextView: TextView = itemView.findViewById(R.id.itemNome)
            val nomeTextNumber: TextView = itemView.findViewById(R.id.itemQuant)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val itemView = LayoutInflater.
                            from(parent.context).
                            inflate(R.layout.list_item,parent,false)
            return ItemViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RecyclerAdapter.ItemViewHolder, position: Int) {
            holder.nomeTextView.text = _itemsList[position].nome
            holder.nomeTextNumber.text = _itemsList[position].quant
        }

        override fun getItemCount(): Int {
            return _itemsList.size
        }

    }
