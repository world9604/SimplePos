package com.example.remote.api.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

internal class RequestHeaderInterceptor : Interceptor {

    val TAG = RequestHeaderInterceptor::class.simpleName

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = try {
            chain.request().newBuilder()
                .apply {
                    addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
                }
                .build()
        } catch (exception: Exception) {
            //ErrorUtil.handleError(exception)
            Log.e(TAG,  "exception : ", exception)
            chain.request()
        }

        return chain.proceed(newRequest)
    }

}
