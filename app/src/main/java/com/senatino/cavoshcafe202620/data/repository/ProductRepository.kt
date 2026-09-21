package com.senatino.cavoshcafe202620.data.repository

import com.senatino.cavoshcafe202620.data.dto.ProductResponseDTO
import com.senatino.cavoshcafe202620.data.network.RetrofitClient

class ProductRepository {

    private val api = RetrofitClient.productApiService

    suspend fun getProductos(categoria: String? = null): Result<List<ProductResponseDTO>> {
        return try {
            val response = api.getProductos(categoria)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error al cargar productos: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getProductoPorId(id: Long): Result<ProductResponseDTO> {
        return try {
            val response = api.getProductoPorId(id)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Producto no encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}