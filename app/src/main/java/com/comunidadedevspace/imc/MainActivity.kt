package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString()
            val altura = edtAltura.text.toString()

            // validacao das variaveis
            if (peso.isEmpty() || altura.isEmpty()) {
                Snackbar.make(edtPeso,
                    "Preencha todos os campos",
                    Snackbar.LENGTH_LONG).show()
            } else {
                // navegar para a próxima tela
                val imc = peso.toFloat() / (altura.toFloat() * altura.toFloat())
                println("pesoa e altura e imc " + peso + altura + imc)

            }

        }

    }

}