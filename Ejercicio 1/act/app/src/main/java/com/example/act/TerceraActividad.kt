package com.example.act

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TerceraActividad : AppCompatActivity() {

    val tasasCambio = mapOf(
        "USD - Dólar" to 1.0,
        "PEN - Nuevo Sol" to 3.4690000000000000,
        "EUR - Euro" to 0.8658200000000000,
        "GBP - Libra" to 0.7475000000000000,
        "INR - Rupia" to 83.1200000000000000,
        "BRL - Real" to 5.2770000000000000,
        "MXN - Peso" to 17.8000000000000000,
        "CNY - Yuan" to 7.2700000000000000,
        "JPY - Yen" to 153.2000000000000000
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tercera_actividad)

        val etCantidad     = findViewById<EditText>(R.id.etCantidad)
        val spinnerOrigen  = findViewById<Spinner>(R.id.spinnerOrigen)
        val spinnerDestino = findViewById<Spinner>(R.id.spinnerDestino)
        val btnConvertir   = findViewById<Button>(R.id.btnConvertir)
        val tvResultado    = findViewById<TextView>(R.id.tvResultado)

        val monedas = tasasCambio.keys.toList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOrigen.adapter  = adapter
        spinnerDestino.adapter = adapter

        btnConvertir.setOnClickListener {
            convertirMoneda(etCantidad, spinnerOrigen, spinnerDestino, tvResultado)
        }
    }

    private fun convertirMoneda(
        etCantidad: EditText,
        spinnerOrigen: Spinner,
        spinnerDestino: Spinner,
        tvResultado: TextView
    ) {
        if (etCantidad.text.isEmpty()) {
            tvResultado.text = "OCURRIÓ UN ERROR TIENES QUE INGRESAR UNA CANTIDAD"
            return
        }

        val cantidad = etCantidad.text.toString().toDoubleOrNull()

        if (cantidad == null) {
            tvResultado.text = "OCURRIÓ UN ERROR TIENES QUE INGRESAR UNA CANTIDAD VÁLIDA"
            return
        }

        val monedaOrigen  = spinnerOrigen.selectedItem.toString()
        val monedaDestino = spinnerDestino.selectedItem.toString()

        val tasaOrigen  = tasasCambio[monedaOrigen] ?: 1.0
        val tasaDestino = tasasCambio[monedaDestino] ?: 1.0

        val enUSD     = cantidad / tasaOrigen
        val resultado = enUSD * tasaDestino

        tvResultado.text = String.format("RESULTADO: %.2f %s", resultado, monedaDestino)
    }
}