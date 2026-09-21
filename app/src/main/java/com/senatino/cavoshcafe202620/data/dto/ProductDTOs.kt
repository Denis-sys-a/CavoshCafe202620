package com.senatino.cavoshcafe202620.data.dto
data class ProductResponseDTO(
    val id: Long,
    val nombre: String,
    val descripcion: String,
    val precioBase: Double,
    val imagenUrl: String,
    val categoria: String,
    val disponible: Boolean
)