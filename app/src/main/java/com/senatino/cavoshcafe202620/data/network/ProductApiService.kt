package com.senatino.cavoshcafe202620.data.network

import com.senatino.cavoshcafe202620.data.dto.ProductResponseDTO
import retrofit2.Response
import retrofit2.http.*

interface ProductApiService {

    @GET("api/productos")
    suspend fun getProductos(
        @Query("categoria") categoria: String? = null
    ): Response<List<ProductResponseDTO>>

    @GET("api/productos/{id}")
    suspend fun getProductoPorId(@Path("id") id: Long): Response<ProductResponseDTO>

    @POST("api/favoritos/{productoId}")
    suspend fun agregarAFavoritos(@Path("productoId") productoId: Long): Response<Unit>

    @DELETE("api/favoritos/{productoId}")
    suspend fun eliminarDeFavoritos(@Path("productoId") productoId: Long): Response<Unit>

    @GET("api/favoritos")
    suspend fun getFavoritos(): Response<List<ProductResponseDTO>>
}