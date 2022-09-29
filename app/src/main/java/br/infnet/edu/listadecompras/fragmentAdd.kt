package br.infnet.edu.listadecompras

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.infnet.edu.listadecompras.databinding.FragmentAddBinding
import br.infnet.edu.listadecompras.model.ItemCompra
import br.infnet.edu.listadecompras.model.ListaCompra

/*
*  TODO salvar input campu quantidade
*  TODO salvar input campo nome
*  TODO funcionalidade botao adicionar
* */
class fragmentAdd : Fragment() {

    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddBinding.inflate(inflater, container, false)


        //homeViewModel.text.observe(viewLifecycleOwner)

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

        //Cria nova instancia de ItemCompra referente a novo item

        val NovoItem = ItemCompra(binding.newItemName.text , binding.newItemNumber.text)

        Toast.makeText(view?.context ,"newItemNumber = ${binding.newItemNumber.text}", Toast.LENGTH_SHORT).show()
        Log.d("addItem()", "addItem() called on button press")

    }

}