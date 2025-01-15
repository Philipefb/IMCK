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

        var classificacao =if (result <= 18.5) {
            "MAGREZA"
        } else if(result > 18.5 && result <= 24.9) {
            "NORMAL"
        } else if (result > 25 && result <= 29.9) {
            "SOBREPESO"
        } else if (result > 30 && result <= 39.9) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao

    }
}