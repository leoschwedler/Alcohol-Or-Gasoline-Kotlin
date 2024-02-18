package com.example.alcoholorgasolinekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alcoholorgasolinekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {
        val precoAlcool = binding.editTextAlcool.text.toString()
        val precoGasolina = binding.editTextGasolina.text.toString()

        if (precoAlcool.isEmpty()) {
            binding.textInputAlcool.error = "Digite o preço do álcool"
            return
        }
        if (precoGasolina.isEmpty()) {
            binding.textInputGasolina.error = "Digite o preço da gasolina"
            return
        }
        val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()
        binding.textResultado.text = if (resultado >= 0.7) {
            "Melhor utilizar Gasolina"
        } else {
            "Melhor utilizar Álcool"
        }
    }
}

