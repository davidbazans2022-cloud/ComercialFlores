package com.example.comercialflores.data.model



data class Producto(
    val id: Int,
    val categoria: String,
    val nombre: String,
    val descripcion: String,
    val precio: String,
    val stock: Int,
    val imagen_url: String?
)

data class ProductoResponse(
    val status: String,
    val total: Int,
    val data: List<Producto>
)