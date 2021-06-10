package com.example.androidisback3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.androidisback3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.isEnabled = false

        binding.editText1.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                habilitarBoton()
            }
        })

        binding.editText2.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                habilitarBoton()
            }
        })

        binding.button.setOnClickListener {
            binding.editText1.text = binding.editText2.text
            binding.editText2.text.clear()
        }

        binding.editText1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                binding.textView.text = binding.editText1.tag.toString()
            }
        }

        binding.editText2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                binding.textView.text = binding.editText2.tag.toString()
            }
        }

        binding.button.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus){
                binding.textView.text = binding.button.tag.toString()
            }
        }
    }

    private fun habilitarBoton(){
        if (binding.editText1.text.isNotEmpty() && binding.editText2.text.isNotEmpty()){
            binding.button.isEnabled=true
        }
    }



}