package br.infnet.edu.listadecompras

import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import br.infnet.edu.listadecompras.databinding.ActivityHomeBinding
import br.infnet.edu.listadecompras.model.ItemsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityHome : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var viewModel:ItemsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ItemsViewModel::class.java]
        viewModel.totalItems().observe(this) {
            binding.totalItemCounter.text = it.toString()
        }
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navBar:BottomNavigationView = binding.navbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostContainer)
            as NavHostFragment
        val navController = navHostFragment.navController
        navBar.setupWithNavController(navController)
        Log.i("HomeActivity", "Called ViewModelProvider.get")
}

    // Oculta/Expoe o contador de itens
    // Chamado ao criar e destruir a view do Fragment Sobre para que o contador nao esteja visivel
    // apenas naquela tela
    fun toggleCounter(){
        val counterText     = binding.itemCounterText
        val totalItemCounter= binding.totalItemCounter

        if(counterText.isVisible){
            counterText.visibility      = INVISIBLE
            totalItemCounter.visibility = INVISIBLE
        }
        else{
            counterText.visibility      = VISIBLE
            totalItemCounter.visibility = VISIBLE
        }
    }
}