package br.infnet.edu.listadecompras

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import br.infnet.edu.listadecompras.databinding.ActivityHomeBinding
import br.infnet.edu.listadecompras.model.ItemsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.system.exitProcess

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

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navBar:BottomNavigationView = binding.navbar
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostContainer)
            as NavHostFragment
        val navController = navHostFragment.navController
        navBar.setupWithNavController(navController)
        Log.i("HomeActivity", "Called ViewModelProvider.get")
}


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.emptyList  -> {
                                    viewModel.emptyList()
                                    Toast.makeText(this,"Lista de itens esvaziada",Toast.LENGTH_SHORT).show()
                                }
            R.id.closeApp   -> {
                                    finishAndRemoveTask()
                                }
        }
        return true
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