package com.oscargil80.todoapproomsqllitemvvm

import androidx.room.*


@Dao
interface DAO {
    @Insert
     fun insertTask(entity: Entity)

    @Update
    suspend fun  updatetask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from To_Do ")
    suspend  fun deleteAll()

    @Query("Select * from To_Do")
    suspend  fun getTask(): List<CardInfo>


}