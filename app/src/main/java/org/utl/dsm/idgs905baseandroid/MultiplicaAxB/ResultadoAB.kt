package org.utl.dsm.idgs905baseandroid.MultiplicaAxB

import android.os.Bundle
import android.widget.TextView // Asegúrate de importar esto
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm.idgs905baseandroid.R

class ResultadoAB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_ab)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val resultado = intent.getStringExtra("EXTRA_RESULTADO")

        tvResultado.text = "$resultado"
    }
}