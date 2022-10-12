package br.infnet.edu.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.infnet.edu.listadecompras.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val btnIniciar = findViewById<View>(R.id.btnIniciar)
        btnIniciar.setOnClickListener {
            val homeIntent = Intent(this, ActivityHome::class.java)
            startActivity(homeIntent)
        }
    }
}