package com.example.comercialflores.data.remote

import com.example.comercialflores.data.model.CategoriaResponse
import retrofit2.http.GET


interface CategoriasService {
 @GET("categorias.php")
 suspend fun getCategorias() : CategoriaResponse

}




