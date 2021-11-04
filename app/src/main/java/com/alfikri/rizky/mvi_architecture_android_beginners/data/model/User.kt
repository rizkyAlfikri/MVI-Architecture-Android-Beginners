package com.alfikri.rizky.mvi_architecture_android_beginners.data.model

import com.squareup.moshi.Json

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version User, v 0.1 11/3/2021 10:34 PM by Rizky Alfikri Rachmat
 */
data class User(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "name") val name: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "avatar") val avatar: String = ""
)
