package com.senatino.cavoshcafe202620.data.repository

import com.senatino.cavoshcafe202620.data.dto.*
import com.senatino.cavoshcafe202620.data.network.RetrofitClient

class OrderRepository {

    private val api = RetrofitClient.orderApiService

    suspend fun getCarrito(): Result<CarritoResponseDTO> {
        return try {
            val response = api.getCarrito()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error al obtener carrito"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun agregarItemCarrito(item: AgregarItemDTO): Result<CarritoResponseDTO> {
        return try {
            val response = api.agregarItemCarrito(item)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error al agregar ítem"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun crearPedido(request: CrearPedidoRequestDTO): Result<PedidoResponseDTO> {
        return try {
            val response = api.crearPedido(request)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error al procesar el pedido"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}