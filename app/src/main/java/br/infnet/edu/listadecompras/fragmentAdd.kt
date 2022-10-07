package br.infnet.edu.listadecompras

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.infnet.edu.listadecompras.databinding.FragmentAddBinding
import br.infnet.edu.listadecompras.model.ItemCompra
import br.infnet.edu.listadecompras.model.ItemsViewModel

class fragmentAdd : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private lateinit var viewModel: ItemsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)

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
            
            if(binding.newItemName.text.isEmpty() || binding.newItemNumber.text.isEmpty()){
               makeToast("Erro: campo em branco")
            }
            else{
                val NovoItem = ItemCompra(binding.newItemName.text.toString() , binding.newItemNumber.text.toString())
                viewModel.addItem(NovoItem)
                makeToast("Item adicionado com sucesso")

                binding.newItemName.setText("")
                binding.newItemNumber.setText("")
                //Toast.makeText(view?.context ,"newItemNumber = ${binding.newItemNumber.text}", Toast.LENGTH_SHORT).show()
                Log.d("addItem()", "addItem() called on button press")
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

    fun Fragment.makeToast(text: String,duration: Int = Toast.LENGTH_LONG) {
        activity?.let {
            Toast.makeText(it, text, duration).show()
        }
    }
}