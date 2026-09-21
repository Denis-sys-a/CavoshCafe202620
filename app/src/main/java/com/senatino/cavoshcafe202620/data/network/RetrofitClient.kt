package com.senatino.cavoshcafe202620.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // 10.0.2.2 apunta a localhost de la PC desde el emulador Android
    private const val BASE_URL = "http://10.0.2.2:8080/"

    // Variable para almacenar temporalmente el token en memoria
    var token: String? = null

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor { token })
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authApiService: AuthApiService by lazy { retrofit.create(AuthApiService::class.java) }
    val productApiService: ProductApiService by lazy { retrofit.create(ProductApiService::class.java) }
    val orderApiService: OrderApiService by lazy { retrofit.create(OrderApiService::class.java) }
}