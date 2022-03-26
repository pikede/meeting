package com.example.meeting.service

import com.example.meeting.models.Sports
import retrofit2.Response
import retrofit2.http.GET

interface api {
    @GET("all_sports.php")
    suspend fun getAllSports(): Response<Sports>
}