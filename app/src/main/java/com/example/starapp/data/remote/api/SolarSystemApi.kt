package com.example.starapp.data.remote.api

import com.example.starapp.data.remote.dto.BodiesResponseDto
import com.example.starapp.data.remote.dto.BodyDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SolarSystemApi {

    @GET("bodies")
    suspend fun getBodies(): BodiesResponseDto

    @GET("bodies/{id}")
    suspend fun getBody(
        @Path("id") id: String
    ): BodyDto
}