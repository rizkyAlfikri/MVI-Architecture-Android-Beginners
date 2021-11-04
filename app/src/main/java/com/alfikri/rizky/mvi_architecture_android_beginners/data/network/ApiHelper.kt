package com.alfikri.rizky.mvi_architecture_android_beginners.data.network

import com.alfikri.rizky.mvi_architecture_android_beginners.data.model.User

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version ApiHelper, v 0.1 11/3/2021 10:36 PM by Rizky Alfikri Rachmat
 */
interface ApiHelper {
    suspend fun getUser(): List<User>
}