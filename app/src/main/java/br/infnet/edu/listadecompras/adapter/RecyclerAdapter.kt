package br.infnet.edu.listadecompras.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.infnet.edu.listadecompras.R
import br.infnet.edu.listadecompras.model.ItemCompra
import br.infnet.edu.listadecompras.model.ItemsViewModel
/*
    class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private lateinit var viewModel: ItemsViewModel
        private var items:List<ItemCompra> = ArrayList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list, parent,false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
            holder.itemName.text = items[position].nome.toString()
            holder.itemQuant.text = items[position].quant.toString()
        }

        override fun getItemCount(): Int {
            return items.size
        }

        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var itemName:TextView
            var itemQuant:TextView

            init {
                itemName = itemView.findViewById(R.id.itemNome)
                itemQuant = itemView.findViewById(R.id.itemQuant)
            }
        }
    }
*/