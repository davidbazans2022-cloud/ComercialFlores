package com.example.comercialflores.ui.screens.menu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comercialflores.data.model.Producto
import com.example.comercialflores.data.repository.ProductosRepository
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {
    private val repository = ProductosRepository()

    var listaProductos by mutableStateOf<List<Producto>>(emptyList())
        private set

    var estaCargando by mutableStateOf(true)
        private set

    var errorConexion by mutableStateOf<String?>(null)
        private set

    init {
        cargarProductos()
    }

    fun cargarProductos() {
        viewModelScope.launch {
            estaCargando = true
            errorConexion = null
            val respuesta = repository.getProductos()
            if (respuesta != null) {
                listaProductos = respuesta
            } else {
                errorConexion = "Error de conexión con el servidor"
            }
            estaCargando = false
        }
    }
}