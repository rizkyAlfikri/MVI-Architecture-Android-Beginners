package com.alfikri.rizky.mvi_architecture_android_beginners.intent

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version MainIntent, v 0.1 11/4/2021 8:01 AM by Rizky Alfikri Rachmat
 */
sealed class MainIntent {

    object FetchUser : MainIntent()
}
