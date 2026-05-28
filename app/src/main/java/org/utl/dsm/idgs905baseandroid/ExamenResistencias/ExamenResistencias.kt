package org.utl.dsm.idgs905baseandroid.ExamenResistencias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.utl.dsm.idgs905baseandroid.R
import android.graphics.Color
import android.view.View
import android.widget.*

class ExamenResistencias : AppCompatActivity() {

    data class ColorData(val nombre: String, val valor: Int, val hex: String)

    private val listaColores = listOf(
        ColorData("Selecciona un color", -1, "#FFFFFF"),
        ColorData("Negro", 0, "#000000"),
        ColorData("Marrón", 1, "#A52A2A"),
        ColorData("Rojo", 2, "#FF0000"),
        ColorData("Naranja", 3, "#FFA500"),
        ColorData("Amarillo", 4, "#FFFF00"),
        ColorData("Verde", 5, "#008000"),
        ColorData("Azul", 6, "#0000FF"),
        ColorData("Violeta", 7, "#8A2BE2"),
        ColorData("Gris", 8, "#808080"),
        ColorData("Blanco", 9, "#FFFFFF")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen_resistencias)


        val spinners = listOf(findViewById<Spinner>(R.id.sp1), findViewById<Spinner>(R.id.sp2), findViewById<Spinner>(R.id.sp3))
        val editTexts = listOf(findViewById<EditText>(R.id.edt1), findViewById<EditText>(R.id.edt2), findViewById<EditText>(R.id.edt3))
        val edtTolerancia = findViewById<EditText>(R.id.edt4)
        val radioGroup = findViewById<RadioGroup>(R.id.rgTolerancia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvValorOhm = findViewById<TextView>(R.id.tvValorOhm)
        val tvValorMax = findViewById<TextView>(R.id.tvValorMax)
        val tvValorMin = findViewById<TextView>(R.id.tvValorMin)


        editTexts.forEach { it.isEnabled = false }
        edtTolerancia.isEnabled = false


        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaColores.map { it.nombre })
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinners.forEachIndexed { index, spinner ->
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (position > 0) {
                        val color = listaColores[position]
                        editTexts[index].setText(color.valor.toString())
                        editTexts[index].setBackgroundColor(Color.parseColor(color.hex))
                        editTexts[index].setTextColor(if (color.valor == 0 || color.valor == 1 || color.valor == 5 || color.valor == 6) Color.WHITE else Color.BLACK)
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }


        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val colorHex = if (checkedId == R.id.rb1) "#FFD700" else "#C0C0C0"
            edtTolerancia.setBackgroundColor(Color.parseColor(colorHex))
            edtTolerancia.setText(if (checkedId == R.id.rb1) "5%" else "10%")
        }


        btnCalcular.setOnClickListener {

            if (spinners.any { it.selectedItemPosition == 0 }) {
                Toast.makeText(this, "Por favor, selecciona un color en cada campo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (radioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Selecciona una tolerancia (Oro/Plata)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val v1 = editTexts[0].text.toString().toInt()
                val v2 = editTexts[1].text.toString().toInt()
                val exponente = editTexts[2].text.toString().toInt()

                val valorBase = (v1 * 10 + v2) * Math.pow(10.0, exponente.toDouble())
                val esOro = radioGroup.checkedRadioButtonId == R.id.rb1
                val tolerancia = if (esOro) 0.05 else 0.10

                val margen = valorBase * tolerancia

                tvValorOhm.text = "Valor ohm: ${valorBase.toInt()} Ω"
                tvValorMax.text = "Valor máximo: ${(valorBase + margen).toInt()} Ω"
                tvValorMin.text = "Valor mínimo: ${(valorBase - margen).toInt()} Ω"
            } catch (e: Exception) {
                Toast.makeText(this, "Error en el cálculo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}