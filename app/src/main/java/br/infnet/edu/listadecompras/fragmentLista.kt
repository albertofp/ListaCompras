package br.infnet.edu.listadecompras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import br.infnet.edu.listadecompras.databinding.FragmentListaBinding
import br.infnet.edu.listadecompras.model.ItemsViewModel

class fragmentLista : Fragment() {

    private var _binding: FragmentListaBinding? = null
    private lateinit var viewModel: ItemsViewModel


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)
        /*
            viewModel.lista.forEach { item ->
                binding.itemNome.setText(item.nome)
                binding.itemQuant.setText(item.quant)
            }
        */

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}