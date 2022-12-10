package nl.project.bored.data

import nl.project.bored.data.local.ActivityDao
import nl.project.bored.data.remote.BoreService
import javax.inject.Inject

class BoredRepository @Inject constructor(
    private val boredService: BoreService, private val activityDao: ActivityDao
) {

    val activity = activityDao.getActivity()

    suspend fun getActivity() {
        activityDao.insertActivity(boredService.fetchActivity())
    }
}