package br.infnet.edu.listadecompras

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.infnet.edu.listadecompras.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class activityHome : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
}}