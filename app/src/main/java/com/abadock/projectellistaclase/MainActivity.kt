package com.abadock.projectellistaclase

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.abadock.projectellistaclase.databinding.ActivityMainBinding
import com.abadock.projectellistaclase.recycler.AlumnesViewModel
import com.abadock.projectellistaclase.recycler.DataSource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.classes,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerClasses.adapter = adapter
        }

        val intent = Intent(this, second::class.java);

        binding.buttonLlistar.setOnClickListener {
            intent.putExtra("curs", binding.spinnerClasses.selectedItem.toString())
            intent.putExtra("nom", binding.inputNom.text.toString())
            startActivity(intent);
        }

        binding.buttonAfegir.setOnClickListener{
            DataSource().addAlumne(AlumnesViewModel(R.drawable.logo_lila, binding.inputNom.text.toString(), binding.inputEdat.text.toString().toInt(), binding.spinnerClasses.selectedItem.toString()))

            binding.inputNom.setText("")
            binding.inputEdat.setText("")

            binding.textView.text = DataSource().loadAlumnes().toString()

        }


    }
}