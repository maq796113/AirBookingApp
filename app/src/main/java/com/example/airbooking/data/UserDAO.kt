package com.example.airbooking.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE uid = :uid")
    suspend fun loadUserById(uid: Int): User?

    @Query("""
        SELECT CASE
            WHEN EXISTS (
                SELECT 1
                FROM user
                WHERE username = :username 
            ) THEN CAST(1 AS BIT)
            ELSE CAST(0 AS BIT)
        END AS result;
        """)
    suspend fun checkIfUsernameExists(username: String): Int



    @Query("""
        SELECT CASE
            WHEN EXISTS (
                SELECT 1
                FROM user
                WHERE username = :username AND passwordHash = :passwordHash
            ) THEN CAST(1 AS BIT)
            ELSE CAST(0 AS BIT)
        END AS result;
        """)
    suspend fun validate(username: String, passwordHash: String): Int



    @Insert(entity = User::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun delete(user: User)
}