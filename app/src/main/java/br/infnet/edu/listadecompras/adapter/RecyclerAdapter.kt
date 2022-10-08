package br.infnet.edu.listadecompras.adapter

import android.content.ClipData
import android.util.Log
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
import kotlinx.coroutines.NonDisposableHandle.parent

class RecyclerAdapter(var itemsList: MutableList<ItemCompra>) : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {


            init {
                Log.d("RecyclerAdapter","RecyclerAdapter initialized")
                Log.d("itemList size","${itemsList.size}")
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
            //holder.nomeTextView.text   = itemsList[position].nome
            //holder.nomeTextNumber.text = itemsList[position].quant
            holder.nomeTextView.setText("${itemsList[position].nome}")
            holder.nomeTextNumber.setText("${itemsList[position].quant}")

            Log.d("onBindViewHolder()","called")
            Log.d("onBindViewHolder()","${holder.nomeTextView.text}")
        }

        override fun getItemCount(): Int {
            return itemsList.size
            Log.i("getItemCount()","_itemsList.size = ${itemsList.size}")
        }

        fun update(lista: MutableList<ItemCompra>){
            itemsList = lista
            notifyDataSetChanged()
        }
    }
