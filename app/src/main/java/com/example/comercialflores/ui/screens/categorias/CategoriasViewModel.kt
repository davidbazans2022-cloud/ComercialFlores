package com.example.comercialflores.ui.screens.categorias

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comercialflores.data.model.Categoria
import com.example.comercialflores.data.repository.CategoriasRepository
import kotlinx.coroutines.launch

class CategoriasViewModel : ViewModel() {
    private val repository = CategoriasRepository()

    // La lista de categorías protegida para que solo el ViewModel la modifique
    var listaCategorias by mutableStateOf<List<Categoria>>(emptyList())
        private set

    init {
        // Se ejecuta automáticamente al abrir la pantalla
        cargarCategorias()
    }

    fun cargarCategorias() {
        viewModelScope.launch {
            val respuesta = repository.getCategorias()
            if (respuesta != null) {
                listaCategorias = respuesta
            }
        }
    }
}