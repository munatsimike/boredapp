package nl.project.bored.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import nl.project.bored.data.remote.BoreService
import nl.project.model.ApiResponse
import javax.inject.Inject

class BoredRepository @Inject constructor(private val boredService: BoreService) {

    suspend fun getActivity(): Flow<ApiResponse> = flowOf(boredService.fetchActivity())
}