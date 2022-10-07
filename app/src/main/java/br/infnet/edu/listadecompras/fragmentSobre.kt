package br.infnet.edu.listadecompras

import android.app.Notification
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://git" +
                    "hub.com/albertofp"))

            //Try-catch deve abrir o link no brower, e, caso nao encontre um,
            // exibir abrir a escolha de aplicativo
            //TODO resolveActivity() para o link para Github, idealmente
            try{
                startActivity(webIntent)
            }catch(e:ActivityNotFoundException){
                //makeToast("No browser found")
                val chooserIntent =
                    Intent(Intent.createChooser(webIntent,"Escolha um aplicativo para abrir o link:"))
                startActivity(chooserIntent)
            }

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

    fun Fragment.makeToast(text: String,duration: Int = Toast.LENGTH_LONG) {
        activity?.let {
            Toast.makeText(it, text, duration).show()
        }
    }
}