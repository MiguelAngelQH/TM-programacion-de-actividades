package com.example.act

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast

class SegundaActividad : AppCompatActivity() {
    private val TIMER_RUNTIME = 10000
    private var nbActivo = false
    private var nProgressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        nProgressBar = findViewById(R.id.progressBar)

        val timerThread = object : Thread() {
            override fun run() {
                nbActivo = true
                try {
                    var espera1 = 0
                    while (nbActivo && espera1 < TIMER_RUNTIME) {
                        sleep(200)
                        if (nbActivo) {
                            espera1 += 200
                            actualizarProgress(espera1)
                        }
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    onContinuar()
                }
            }
        }
        timerThread.start()
    }

    fun actualizarProgress(timePassed: Int) {
        nProgressBar?.let {
            val progress = it.max * timePassed / TIMER_RUNTIME
            runOnUiThread {
                it.progress = progress
                // Cuando el progreso llega al 100%, mostrar mensaje
                if (progress >= 100) {
                    Toast.makeText(this, "¡Carga completa!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun onContinuar() {
        Log.d("mensajeFinal", "Su barra de progreso acaba de cargar")
        runOnUiThread {
            Toast.makeText(this, "La barra de progreso ha completado su carga", Toast.LENGTH_LONG).show()
        }
    }
}