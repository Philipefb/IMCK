package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao_label)

        tvResult.text = result.toString()

        when {
            result <= 18.5 -> {
                tvClassificacao.text = "MAGREZA"
                tvClassificacao.setTextColor(getColor(R.color.IMC_MAGREZA))
            }
            result in 18.5..24.9 -> {
                tvClassificacao.text = "NORMAL"
                tvClassificacao.setTextColor(getColor(R.color.IMC_NORMAL))
            }
            result in 25.0..29.9 -> {
                tvClassificacao.text = "SOBREPESO"
                tvClassificacao.setTextColor(getColor(R.color.IMC_SOBREPESO))
            }
            result in 30.0..39.9 -> {
                tvClassificacao.text = "OBESIDADE"
                tvClassificacao.setTextColor(getColor(R.color.IMC_OBESIDADE))
            }
            else -> {
                tvClassificacao.text = "OBESIDADE GRAVE"
                tvClassificacao.setTextColor(getColor(R.color.IMC_MAGREZA))
            }
        }
    }
}