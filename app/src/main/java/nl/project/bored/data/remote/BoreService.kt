package nl.project.bored.data.remote

import nl.project.model.Activity
import retrofit2.http.GET

interface BoreService {
    @GET("activity/")
    suspend fun fetchActivity() : Activity
}