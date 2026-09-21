package com.senatino.cavoshcafe202620.data.repository

import com.senatino.cavoshcafe202620.data.dto.AuthResponseDTO
import com.senatino.cavoshcafe202620.data.dto.LoginRequestDTO
import com.senatino.cavoshcafe202620.data.dto.RegisterRequestDTO
import com.senatino.cavoshcafe202620.data.network.RetrofitClient
import retrofit2.Response

class AuthRepository {

    private val api = RetrofitClient.authApiService

    suspend fun login(request: LoginRequestDTO): Result<AuthResponseDTO> {
        return try {
            val response = api.login(request)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error en autenticación: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(request: RegisterRequestDTO): Result<AuthResponseDTO> {
        return try {
            val response = api.register(request)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error en registro: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}