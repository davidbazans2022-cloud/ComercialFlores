package com.example.comercialflores.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.getValue
import kotlin.jvm.java

object RetrofitClient {

    private const val BASE_URL = "https://davidbzn.alwaysdata.net/"

   private val retrofit by lazy {

       Retrofit.Builder().baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()

   }

    val categoriasService : CategoriasService  by lazy{
        retrofit.create(CategoriasService::class.java)
    }

    val productosService : ProductosService by lazy {
        retrofit.create(ProductosService::class.java)
    }



    }



