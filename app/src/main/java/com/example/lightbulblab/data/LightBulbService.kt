package com.example.lightbulblab.data

import com.example.lightbulblab.data.model.BrightnessLevel
import com.example.lightbulblab.data.model.ColorInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LightBulbService {
    @GET("state/")
    suspend fun getState() : Response<Boolean>

    @POST("state/on")
    suspend fun turnOn(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOff(): Response<Boolean>

    @GET("color/")
    suspend fun getColors(): Response<List<ColorInfo>>

    @POST("color/")
    suspend fun setColor(@Query("color") color: String): Response<Boolean>

    @GET("color/names_only")
    suspend fun getColorNames(): Response<List<String>>

    @GET("color/current")
    suspend fun getCurrentColor() : Response<ColorInfo>

    @GET("brightness/")
    suspend fun getBrightnessLevels() : Response<BrightnessLevel>

    @POST("brightness/")
    suspend fun setBrightness(@Query("level") level: Int): Response<Boolean>

    @GET("brightness/current")
    suspend fun getCurrentBrightness(): Response<Int>

}
