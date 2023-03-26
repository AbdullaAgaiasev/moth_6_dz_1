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

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val text = result.data?.getStringExtra("text")
                binding.editText1.setText(text)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.button1.setOnClickListener {
            if (binding.editText1.text.isEmpty()) {
                Toast.makeText(this, "Это поле не может быть пустым!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, TransitionActivity::class.java)
                intent.putExtra("text1", binding.editText1.text.toString())
                setResult(Activity.RESULT_OK, intent)
                launcher.launch(intent)
            }
        }
    }
}