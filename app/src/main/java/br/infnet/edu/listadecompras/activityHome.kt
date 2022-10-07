package br.infnet.edu.listadecompras

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.infnet.edu.listadecompras.databinding.ActivityHomeBinding
import br.infnet.edu.listadecompras.model.ItemsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class activityHome : AppCompatActivity() {

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    private lateinit var viewModel:ItemsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemsViewModel::class.java)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navBar:BottomNavigationView = binding.navbar
        //val navBar = findViewById<BottomNavigationView>(R.id.navbar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostContainer)
            as NavHostFragment
        val navController = navHostFragment.navController
        navBar.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.addDest,
            R.id.listDest,
            R.id.sobreDest))
        //setupActionBarWithNavController(navController,appBarConfiguration)
        Log.i("HomeActivity", "Called ViewModelProvider.get")
}}