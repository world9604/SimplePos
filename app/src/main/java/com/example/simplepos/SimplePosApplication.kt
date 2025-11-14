package com.example.simplepos

import androidx.annotation.CallSuper
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SimplePosApplication: MultiDexApplication() {

    val baseUrl: String
        get() = "https://api.themoviedb.org/3/"

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: SimplePosApplication
            private set

    }
}