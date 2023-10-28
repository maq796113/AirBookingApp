package com.example.airbooking.data

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<User>>

    suspend fun loadUserById(uid: Int): User?

    suspend fun checkIfUsernameExists(username: String): Int

    suspend fun validate(username: String, passwordHash: String): Int

    suspend fun insertUser(user: User)

    suspend fun delete(user: User)
}