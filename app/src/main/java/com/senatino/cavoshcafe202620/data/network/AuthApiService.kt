package com.senatino.cavoshcafe202620.data.network

import com.senatino.cavoshcafe202620.domain.model.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("api/auth/login")
    suspend fun login(@Body request: Map<String, String>): Response<Usuario>

    @POST("api/auth/registrar")
    suspend fun registrar(@Body usuario: Usuario): Response<Void>
}