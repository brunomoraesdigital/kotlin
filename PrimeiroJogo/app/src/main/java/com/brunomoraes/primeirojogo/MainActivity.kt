    package com.brunomoraes.primeirojogo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variável para guardar os pontos
    var pontos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Isso liga o código ao seu desenho XML
        setContentView(R.layout.activity_main)

        // Ligando os componentes pelos IDs que você criou
        val botao = findViewById<Button>(R.id.btnClique)
        val texto = findViewById<TextView>(R.id.txtContador)

        // Configurando a ação do botão
        botao.setOnClickListener {
            pontos = pontos + 1
            texto.text = "Pontos: $pontos"
            if (pontos < 10) {
                texto.setTextColor(Color.GREEN)
                botao.setBackgroundColor(Color.parseColor("#a0d2f3"))
            } else {
                texto.setTextColor(Color.RED)
                botao.setBackgroundColor(Color.parseColor("#f7cae7"))
            }
        }
    }
}