package com.example.moth_6_dz_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.moth_6_dz_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val getText = registerForActivityResult(SendTextContract()) {
        binding.editText1.setText(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.button1.setOnClickListener {
            if (binding.editText1.text.isNotEmpty()) {
                getText.launch(binding.editText1.text)
            } else {
                toastShort(this, "Здесь не должно быть пусто!")
            }
        }
    }
}