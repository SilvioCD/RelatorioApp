package com.ralatorio.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bando = findViewById<EditText>(R.id.bando)
        val artigo = findViewById<EditText>(R.id.artigo)
        val entrada = findViewById<EditText>(R.id.entrada)
        val saida = findViewById<EditText>(R.id.saida)
        val ocorrencias = findViewById<EditText>(R.id.ocorrencias)
        val resultado = findViewById<TextView>(R.id.resultado)
        val botao = findViewById<Button>(R.id.botao)

        botao.setOnClickListener {
            try {
                val ent = entrada.text.toString().toInt()
                val sai = saida.text.toString().toInt()
                val rendimento = if (ent != 0) (sai.toDouble() / ent * 100).toInt() else 0
                val texto = """
                    ⚠${bando.text} - bando
                    ✅Artigo: ${artigo.text}
                    Entrada = $ent
                    Saída = $sai
                    Rendimento: $rendimento%
                    
                    ⏩ Ocorrências:
                    ${ocorrencias.text}
                """.trimIndent()
                resultado.text = texto
            } catch (e: Exception) {
                resultado.text = "Erro nos valores numéricos."
            }
        }
    }
}
