package com.alfikri.rizky.mvi_architecture_android_beginners.data.network

import com.alfikri.rizky.mvi_architecture_android_beginners.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version ApiService, v 0.1 11/3/2021 10:36 PM by Rizky Alfikri Rachmat
 */
interface ApiService {
    @GET("testUsers")
    suspend fun getUsers(): List<User>
}