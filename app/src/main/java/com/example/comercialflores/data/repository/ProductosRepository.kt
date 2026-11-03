package com.example.comercialflores.data.repository

import com.example.comercialflores.data.model.Producto
import com.example.comercialflores.data.remote.RetrofitClient

class ProductosRepository {
    suspend fun getProductos(): List<Producto>? {
        return try {
            RetrofitClient.productosService.getProductos().data
        } catch (e: Exception) {
            null
        }
    }
}