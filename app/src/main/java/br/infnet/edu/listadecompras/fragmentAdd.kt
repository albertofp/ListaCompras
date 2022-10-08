package br.infnet.edu.listadecompras

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import br.infnet.edu.listadecompras.databinding.FragmentAddBinding
import br.infnet.edu.listadecompras.model.ItemCompra
import br.infnet.edu.listadecompras.model.ItemsViewModel

class fragmentAdd : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val viewModel: ItemsViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("fragmAdd.onCreateView()","called")
        _binding = FragmentAddBinding.inflate(inflater, container, false)
       // viewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)

        binding.newItemName.setOnFocusChangeListener{
            _ , hasFocus ->
            if(hasFocus){
                binding.newItemName.setText("")
            }
        }

        binding.newItemNumber.setOnFocusChangeListener{
                _ , hasFocus ->
            if(hasFocus){
                binding.newItemNumber.setText("")
            }
        }

        // Adicionar funcionalidade de adicionar novo item a lista ao clicar no botao de "+"
        val btnAdd = binding.btnAdd
        btnAdd.setOnClickListener{

            // Nao tenta adicionar item a lista se um dos campos esta em branco
            if(binding.newItemName.text.isEmpty() || binding.newItemNumber.text.isEmpty()){
               makeToast("Erro: campo(s) em branco")
                Log.d("error:empty field","Did not add item (empty field)")
            }
            else{
                val NovoItem = ItemCompra(binding.newItemName.text.toString() ,
                                            binding.newItemNumber.text.toString())
                viewModel.addItem(NovoItem)
                makeToast("Item adicionado com sucesso")
                Log.d("item added","$NovoItem added to items list")
                Log.d("item list",viewModel.exposeItems().toString())

                binding.newItemName.setText("")
                binding.newItemNumber.setText("")
            }
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun Fragment.makeToast(text: String,duration: Int = Toast.LENGTH_SHORT) {
        activity?.let {
            Toast.makeText(it, text, duration).show()
        }
    }
}