package nl.project.bored.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import nl.project.model.Activity

@Database(entities = [Activity::class], version = 1)
abstract class AppDatabase() : RoomDatabase() {
    abstract val activityDao: ActivityDao
}