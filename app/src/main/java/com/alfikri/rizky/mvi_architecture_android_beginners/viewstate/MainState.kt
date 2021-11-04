package com.alfikri.rizky.mvi_architecture_android_beginners.viewstate

import com.alfikri.rizky.mvi_architecture_android_beginners.data.model.User

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version MainState, v 0.1 11/4/2021 8:03 AM by Rizky Alfikri Rachmat
 */
sealed class MainState {

    object Loading : MainState()
    object Idle : MainState()
    data class Users(val user: List<User>) : MainState()
    data class Error(val message: String) : MainState()
}
