package org.utl.dsm.idgs905baseandroid.MultiplicaAxB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.dsm.idgs905baseandroid.Ejemplo2.ResultActivity
import org.utl.dsm.idgs905baseandroid.R

class MultiplicaAxB : AppCompatActivity() {

    private lateinit var edtA: EditText
    private lateinit var edtB: EditText
    private lateinit var btnSumar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplica_ax_b)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        edtA = findViewById(R.id.edtA)
        edtB = findViewById(R.id.edtB)
        btnSumar = findViewById(R.id.btnSumar)

        btnSumar.setOnClickListener {
            val strNum1 = edtA.text.toString()
            val strNum2 = edtB.text.toString()

            if (strNum1.isNotEmpty() && strNum2.isNotEmpty()) {
                val num1 = Integer.parseInt(strNum1)
                val num2 = Integer.parseInt(strNum2)
                val resultado = sumar(num1, num2)

                val intent = Intent(this, ResultadoAB::class.java)
                intent.putExtra("EXTRA_RESULTADO", resultado.toString())
                startActivity(intent)

            } else {
                android.widget.Toast.makeText(this, "Por favor, llena ambos campos", android.widget.Toast.LENGTH_SHORT).show()

            }
        }

    }


    fun sumar(A: Int, B: Int): Int {
        var total = 0

        for (i in 1..B) {
            total += A
        }
        return total
    }
}