package com.senatino.cavoshcafe202620.data.network

import com.senatino.cavoshcafe202620.data.dto.AgregarItemDTO
import com.senatino.cavoshcafe202620.data.dto.CarritoResponseDTO
import com.senatino.cavoshcafe202620.data.dto.CrearPedidoRequestDTO
import com.senatino.cavoshcafe202620.data.dto.PedidoResponseDTO
import retrofit2.Response
import retrofit2.http.*

interface OrderApiService {

    // Carrito
    @GET("api/carrito")
    suspend fun getCarrito(): Response<CarritoResponseDTO>

    @POST("api/carrito/items")
    suspend fun agregarItemCarrito(@Body item: AgregarItemDTO): Response<CarritoResponseDTO>

    @DELETE("api/carrito/items/{itemId}")
    suspend fun eliminarItemCarrito(@Path("itemId") itemId: Long): Response<CarritoResponseDTO>

    // Pedidos
    @POST("api/pedidos")
    suspend fun crearPedido(@Body request: CrearPedidoRequestDTO): Response<PedidoResponseDTO>

    @GET("api/pedidos/{id}")
    suspend fun getEstadoPedido(@Path("id") id: Long): Response<PedidoResponseDTO>

    @GET("api/pedidos/historial")
    suspend fun getHistorialPedidos(): Response<List<PedidoResponseDTO>>
}