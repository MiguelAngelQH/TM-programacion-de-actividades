package com.example.act

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.act.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "Ciclo de Vida"
    private lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "En el evento onCreate()")

        loadingDialog = LoadingDialog(this)

        binding.btnMostrar.setOnClickListener {
            loadingDialog.startLoading("Cargando Segunda Actividad...")
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, SegundaActividad::class.java))
                loadingDialog.stopLoading("Segunda actividad cargada")
            }, 2000)
        }

        binding.btnMonedas.setOnClickListener {
            loadingDialog.startLoading("Cargando Conversor de Monedas...")
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, TerceraActividad::class.java))
                loadingDialog.stopLoading("Conversor de monedas cargado")
            }, 2000)
        }

        binding.btnDrawer.setOnClickListener {
            loadingDialog.startLoading("Cargando Menú de Navegación...")
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, CuartaActividad::class.java))
                loadingDialog.stopLoading("Menú de navegación cargado")
            }, 2000)
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "En el evento onStart()") }
    override fun onRestart() { super.onRestart(); Log.d(TAG, "En el evento onRestart()") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "En el evento onResume()") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "En el evento onPause()") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "En el evento onStop()") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "En el evento onDestroy()") }
}