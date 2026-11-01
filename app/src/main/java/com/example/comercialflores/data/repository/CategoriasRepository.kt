package com.example.comercialflores.data.repository

import com.example.comercialflores.data.model.Categoria
import com.example.comercialflores.data.remote.RetrofitClient



class CategoriasRepository{
suspend fun getCategorias() : List<Categoria>?{
   return try {
       val response = RetrofitClient.categoriasService.getCategorias()
       response.data}  catch (e: Exception){
           e.message.toString()
       null
       }


}
}