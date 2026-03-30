package com.example.act

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.act.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "Ciclo de Vida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "En el evento onCreate()")

        binding.btnMostrar.setOnClickListener {
            startActivity(Intent(this, SegundaActividad::class.java))
        }
        binding.btnMonedas.setOnClickListener {
            startActivity(Intent(this, TerceraActividad::class.java))
        }
        binding.btnDrawer.setOnClickListener {
            startActivity(Intent(this, CuartaActividad::class.java))
        }
    }

    override fun onStart()   { super.onStart();   Log.d(TAG, "En el evento onStart()") }
    override fun onRestart() { super.onRestart(); Log.d(TAG, "En el evento onRestart()") }
    override fun onResume()  { super.onResume();  Log.d(TAG, "En el evento onResume()") }
    override fun onPause()   { super.onPause();   Log.d(TAG, "En el evento onPause()") }
    override fun onStop()    { super.onStop();    Log.d(TAG, "En el evento onStop()") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "En el evento onDestroy()") }
}