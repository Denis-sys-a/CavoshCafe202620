package com.senatino.cavoshcafe202620.data.dto

data class AgregarItemDTO(
    val productoId: Long,
    val cantidad: Int,
    val tamaño: String,
    val tipoLeche: String?,
    val cremaBatida: Boolean,
    val sinCafeina: Boolean
)

data class ItemCarritoDTO(
    val id: Long,
    val producto: ProductResponseDTO,
    val cantidad: Int,
    val precioSubtotal: Double,
    val tamaño: String,
    val especificaciones: String
)

data class CarritoResponseDTO(
    val id: Long,
    val items: List<ItemCarritoDTO>,
    val total: Double
)
