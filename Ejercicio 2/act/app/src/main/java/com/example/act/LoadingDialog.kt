package com.example.act

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class LoadingDialog(private val context: Context) {
    private var dialog: AlertDialog? = null
    fun startLoading(message: String = "Cargando...") {
        try {
            val builder = AlertDialog.Builder(context)
            val inflater = (context as AppCompatActivity).layoutInflater
            val view = inflater.inflate(R.layout.dialog_loading, null)
            val textView = view.findViewById<TextView>(R.id.textViewLoading)
            textView.text = message
            builder.setView(view)
            builder.setCancelable(false)
            dialog = builder.create()
            dialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun stopLoading(message: String = "Carga completa") {
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                dialog?.dismiss()
                dialog = null
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, 1000)
    }
    fun isShowing(): Boolean {
        return dialog?.isShowing == true
    }
}