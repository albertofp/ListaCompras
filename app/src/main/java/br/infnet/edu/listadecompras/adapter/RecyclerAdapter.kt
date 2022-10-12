package br.infnet.edu.listadecompras.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.infnet.edu.listadecompras.R
import br.infnet.edu.listadecompras.model.ItemCompra

typealias onItemClicked = (position: Int) -> Unit

class RecyclerAdapter(
    private var _itemsList: MutableList<ItemCompra>,
    private val onItemClicked: onItemClicked
) : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    init {
        Log.d("RecyclerAdapter", "RecyclerAdapter initialized")
        Log.d("itemList size", "${_itemsList.size}")
    }

    inner class ItemViewHolder(itemView: View, private val onItemClicked: onItemClicked) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nomeTextView: TextView = itemView.findViewById(R.id.itemNome)
        val nomeTextNumber: TextView = itemView.findViewById(R.id.itemQuant)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClicked(position)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        Log.d("onCreateViewHolder()", "RecyclerAdapter.onCreateViewHolder() called")

        return ItemViewHolder(itemView, onItemClicked)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ItemViewHolder, position: Int) {
        holder.nomeTextView.text = _itemsList[position].nome
        holder.nomeTextNumber.text = _itemsList[position].quant

        Log.d("onBindViewHolder()", "called")
        Log.d("onBindViewHolder()", "${holder.nomeTextView.text}")
    }

    override fun getItemCount(): Int {
        return _itemsList.size
    }
}
