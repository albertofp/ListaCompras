package br.infnet.edu.listadecompras

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.infnet.edu.listadecompras.databinding.FragmentSobreBinding

class fragmentSobre : Fragment() {

    private var _binding: FragmentSobreBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSobreBinding.inflate(inflater, container, false)

        //Adiciona o Implicit Intent para abrir o link do Github ao clickar no botao
        binding.btnGithub.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/albertofp"))
            startActivity(intent)
        })
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