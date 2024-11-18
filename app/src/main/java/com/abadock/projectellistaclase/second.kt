package com.abadock.projectellistaclase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.abadock.projectellistaclase.databinding.ActivitySecondBinding
import com.abadock.projectellistaclase.recycler.AlumnesAdapter
import com.abadock.projectellistaclase.recycler.DataSource

class second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)



        val extras = intent.extras
        if (extras != null) {
            val nom = extras.getString("nom")
            if (nom != null) {
                DataSource().reOrder(nom)
            }

            val curs = extras.getString("curs")
            binding.recyclerView.adapter = AlumnesAdapter(DataSource().loadAlumnes().filter { it.curs == curs})
        }


        binding.buttonTornar.setOnClickListener {
            finish()
        }






    }
}