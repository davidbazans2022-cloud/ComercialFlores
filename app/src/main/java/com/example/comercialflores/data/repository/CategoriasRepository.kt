package com.example.comercialflores.data.repository

import com.example.comercialflores.data.model.Categoria
import com.example.comercialflores.data.remote.RetrofitClient



class CategoriasRepository {
    suspend fun getCategorias(): List<Categoria>? {
        return try {
            RetrofitClient.categoriasService.getCategorias().data
        } catch (e: Exception) {
            null
        }
    }
}