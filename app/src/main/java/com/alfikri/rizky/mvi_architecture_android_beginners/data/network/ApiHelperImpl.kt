package com.alfikri.rizky.mvi_architecture_android_beginners.data.network

import com.alfikri.rizky.mvi_architecture_android_beginners.data.model.User

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version ApiHelperImpl, v 0.1 11/3/2021 10:39 PM by Rizky Alfikri Rachmat
 */
class ApiHelperImpl(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun getUser(): List<User> {
        return  apiService.getUsers()
    }
}