package com.senatino.cavoshcafe202620.data.dto
data class CrearPedidoRequestDTO(
    val sucursalId: Long,
    val metodoEntrega: String,
    val fechaProgramada: String?,
    val metodoPago: String
)

data class PedidoResponseDTO(
    val id: Long,
    val numeroPedido: String,
    val estado: String,
    val total: Double,
    val fechaCreacion: String
)