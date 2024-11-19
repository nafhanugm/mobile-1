package com.nafhan.myapplication.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import com.nafhan.myapplication.entity.Voter
import kotlinx.coroutines.flow.Flow

@Dao
interface VoterDao {
    @Query("SELECT * FROM voters")
    fun getAllVoters(): Flow<List<Voter>>

    @Query("SELECT * FROM voters WHERE id = :id")
    fun getVoterById(id: Int): Flow<Voter>

    @Insert
    suspend fun insertVoter(voter: Voter)

    @Update
    suspend fun updateVoter(voter: Voter)

    @Delete
    suspend fun deleteVoter(voter: Voter)
}