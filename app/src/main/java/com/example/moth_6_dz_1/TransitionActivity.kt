package com.example.moth_6_dz_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moth_6_dz_1.SendTextContract.Key.TEXT_KEY
import com.example.moth_6_dz_1.databinding.TransitionActivityBinding

class TransitionActivity: AppCompatActivity() {

    private lateinit var binding: TransitionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransitionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.editText2.setText(intent.getCharSequenceExtra(TEXT_KEY))
        binding.button2.setOnClickListener {
            if (binding.editText2.text.isNotEmpty()) {
                sendResult()
            } else {
                toastShort(this, "Здесь не должно быть пусто!")
            }
        }
    }

    private fun sendResult() {
        val data = Intent().putExtra(TEXT_KEY, binding.editText2.text as CharSequence)
        setResult(RESULT_OK, data)
        finish()
    }
}