package com.example.comercialflores.data.model






data class  Categoria (
        val id : Int,
        val nombre : String

        )
data class  CategoriaResponse(
        val status : String,
        val total : Int,
        val data : List<Categoria>

        )