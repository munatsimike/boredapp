package nl.project.bored.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import nl.project.model.Activity

@Dao
interface ActivityDao {
    @Query("SELECT * FROM ACTIVITY_TABLE")
    fun getActivity(): Flow<Activity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: Activity)
}