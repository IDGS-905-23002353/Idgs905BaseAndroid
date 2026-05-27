package org.utl.dsm.idgs905baseandroid.Distancia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm.idgs905baseandroid.R
import kotlin.math.pow
import kotlin.math.sqrt

class distancia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)


        val etX1 = findViewById<EditText>(R.id.x1)
        val etY1 = findViewById<EditText>(R.id.y1)
        val etX2 = findViewById<EditText>(R.id.x2)
        val etY2 = findViewById<EditText>(R.id.y2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {

            val x1 = etX1.text.toString().toDoubleOrNull() ?: 0.0
            val y1 = etY1.text.toString().toDoubleOrNull() ?: 0.0
            val x2 = etX2.text.toString().toDoubleOrNull() ?: 0.0
            val y2 = etY2.text.toString().toDoubleOrNull() ?: 0.0

            val res = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))


            tvResultado.text = "Resultado: %.2f".format(res)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}