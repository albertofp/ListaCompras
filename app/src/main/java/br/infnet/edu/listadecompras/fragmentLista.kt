package br.infnet.edu.listadecompras

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.infnet.edu.listadecompras.adapter.RecyclerAdapter
import br.infnet.edu.listadecompras.databinding.FragmentListaBinding
import br.infnet.edu.listadecompras.model.ItemCompra
import br.infnet.edu.listadecompras.model.ItemsViewModel

class fragmentLista : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private val viewModel: ItemsViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding    = FragmentListaBinding.inflate(inflater, container, false)
        recyclerView= binding.recyclerView
        configureRecyclerView()
        Log.d("fragmentLista","onCreateView() called")

        //return binding.root

        //Opcao abaixo gera erro: "RecyclerView: No adapter attached; skipping layout"
        return inflater.inflate(R.layout.fragment_lista,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
        Log.d("fragmentLista","onViewCreated() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureRecyclerView(){
        Log.d("configureRecyclerView()","${viewModel.exposeItems().size}")
        recyclerView.layoutManager  = LinearLayoutManager(activity)
        recyclerView.adapter        = RecyclerAdapter(viewModel.exposeItems())
        recyclerView.addItemDecoration(
            DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
    }
}