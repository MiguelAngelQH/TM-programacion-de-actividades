package com.example.act

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class CuartaActividad : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var tvContenido: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuarta_actividad)

        drawerLayout = findViewById(R.id.drawerLayout)
        tvContenido  = findViewById(R.id.tvContenido)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.navigationView)

        // Agregamos los items del menú directamente por código
        val menu = navigationView.menu
        menu.add(0, 1, 0, "Inicio").setIcon(android.R.drawable.ic_menu_compass)
        menu.add(0, 2, 1, "Conversión de Monedas").setIcon(android.R.drawable.ic_menu_manage)
        menu.add(0, 3, 2, "Barra de Progreso").setIcon(android.R.drawable.ic_menu_rotate)
        menu.add(0, 4, 3, "Acerca de").setIcon(android.R.drawable.ic_menu_info_details)

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            1 -> {
                tvContenido.text = "HOLA!"
            }
            2 -> {
                drawerLayout.closeDrawers()
                startActivity(Intent(this, TerceraActividad::class.java))
                return true
            }
            3 -> {
                drawerLayout.closeDrawers()
                startActivity(Intent(this, SegundaActividad::class.java))
                return true
            }
            4 -> {
                tvContenido.text = "Miguel Angel Quispe Huayhua\nVersión 1.0"
            }
        }
        drawerLayout.closeDrawers()
        return true
    }
}