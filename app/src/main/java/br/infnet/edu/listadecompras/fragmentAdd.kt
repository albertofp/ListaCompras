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
        val btnAdd = binding.btnAdd
        btnAdd.setOnClickListener{addItem()}
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addItem(){
        val NovoItem = ItemCompra(binding.newItemName.text , binding.newItemNumber.text)
        viewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)
        viewModel.lista.addItem(NovoItem)
        //Toast.makeText(view?.context ,"newItemNumber = ${binding.newItemNumber.text}", Toast.LENGTH_SHORT).show()
        Log.d("addItem()", "addItem() called on button press")
        Log.d("lista items", "teste")

    }

}