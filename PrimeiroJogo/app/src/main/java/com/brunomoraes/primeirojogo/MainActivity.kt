package com.brunomoraes.primeirojogo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        val imagem = findViewById<android.widget.ImageView>(R.id.imgTrofeu)

        // Configurando a ação do botão
        botao.setOnClickListener {
            pontos = pontos + 1
            texto.text = "Pontos: $pontos"
            if (pontos < 10) {
                texto.setTextColor(Color.GREEN)
                botao.setBackgroundColor(Color.parseColor("#a0d2f3"))
            } else if (pontos == 10) {
                Toast.makeText(this, "Parabéns! Você chegou aos 10 pontos!", Toast.LENGTH_SHORT)
                    .show()
                botao.performHapticFeedback(
                    android.view.HapticFeedbackConstants.LONG_PRESS
                )
                texto.setTextColor(Color.YELLOW)
                botao.setBackgroundColor(Color.parseColor("#FCF3B0"))
                imagem.visibility = android.view.View.VISIBLE
            } else {
                texto.setTextColor(Color.RED)
                botao.setBackgroundColor(Color.parseColor("#f7cae7"))
            }
        }
        // Configurando o clique longo para resetar
        botao.setOnLongClickListener {
            imagem.visibility = android.view.View.INVISIBLE
            pontos = 0
            texto.text = "Pontos: $pontos"
            texto.setTextColor(Color.WHITE)
            botao.setBackgroundColor(Color.LTGRAY)

            Toast.makeText(this, "Jogo Reiniciado!", Toast.LENGTH_SHORT).show()
            botao.performHapticFeedback(android.view.HapticFeedbackConstants.LONG_PRESS)


            texto.text = "Pontos: $pontos"
            true // Isso diz ao Android que o clique longo foi "consumido"
        }
    }
}