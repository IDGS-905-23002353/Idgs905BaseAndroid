package org.utl.dsm.idgs905baseandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java
import android.widget.Button
import  org.utl.dsm.idgs905baseandroid.Ejemplo1.ejemplo1
import android.content.Intent
import org.utl.dsm.idgs905baseandroid.Ejemplo2.Ejemplo2Activity
import org.utl.dsm.idgs905baseandroid.Distancia.distancia
import org.utl.dsm.idgs905baseandroid.ExamenResistencias.ExamenResistencias
import org.utl.dsm.idgs905baseandroid.MultiplicaAxB.MultiplicaAxB
import org.utl.dsm.idgs905baseandroid.MultiplicaAxB.ResultadoAB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        val btnDistancia=findViewById<Button>(R.id.btn2)
        val btnEjemplo2Activity=findViewById<Button>(R.id.btn3)
        val btnAB=findViewById<Button>(R.id.btn4)
        val btnExamenResistencias=findViewById<Button>(R.id.btn5)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnEjemplo1.setOnClickListener{ navegateToEjemplo1()}
        btnDistancia.setOnClickListener{ navegateToDistancia()}
        btnEjemplo2Activity.setOnClickListener{ navegateToEjemplo2Activity()}
        btnAB.setOnClickListener{ navegateToAB()}
        btnExamenResistencias.setOnClickListener{ navegateToExamenResistencias()}
    }

    fun navegateToEjemplo1(){
        val intent = Intent(this,  ejemplo1::class.java)
        startActivity(
            intent
        )
    }

    fun navegateToDistancia() {
        val intent = Intent(this, distancia::class.java)
        startActivity(intent)
    }

    fun navegateToEjemplo2Activity() {
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

    fun navegateToAB() {
        val intent = Intent(this, MultiplicaAxB::class.java)
        startActivity(intent)
    }

    fun navegateToExamenResistencias() {
        val intent = Intent(this, ExamenResistencias::class.java)
        startActivity(intent)
    }
}