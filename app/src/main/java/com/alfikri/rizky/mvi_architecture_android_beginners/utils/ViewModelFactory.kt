package com.alfikri.rizky.mvi_architecture_android_beginners.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alfikri.rizky.mvi_architecture_android_beginners.data.MainRepository
import com.alfikri.rizky.mvi_architecture_android_beginners.data.network.ApiHelper
import com.alfikri.rizky.mvi_architecture_android_beginners.view.MainViewModel
import java.lang.IllegalArgumentException

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version ViewModelFactory, v 0.1 11/4/2021 8:20 AM by Rizky Alfikri Rachmat
 */
class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(MainRepository(apiHelper)) as T
            }

            else -> throw IllegalArgumentException("Unknown Class name")
        }
    }
}