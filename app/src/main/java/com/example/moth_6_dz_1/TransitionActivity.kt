package com.example.moth_6_dz_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moth_6_dz_1.databinding.TransitionActivityBinding

class TransitionActivity: AppCompatActivity() {

    private lateinit var binding: TransitionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransitionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText2.setText(intent.getStringExtra("text1"))

        binding.button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("text1", binding.editText2.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}