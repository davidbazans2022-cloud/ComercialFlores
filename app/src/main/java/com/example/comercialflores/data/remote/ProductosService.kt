package com.example.comercialflores.data.remote
import com.example.comercialflores.data.model.CategoriaResponse
import com.example.comercialflores.data.model.ProductoResponse
import retrofit2.http.GET

interface ProductosService {
    @GET("producto.php")
    suspend fun getProductos() : ProductoResponse
}