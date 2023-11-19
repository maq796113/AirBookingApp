package com.example.airbooking.data

import kotlinx.coroutines.flow.Flow

class UserRepositoryImplementation(
    private val dao: UserDAO
) : UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return dao.getUsers()
    }

    override suspend fun checkIfUsernameExists(username: String): Int {
        return dao.checkIfUsernameExists(username)
    }

    override suspend fun validate(username: String, passwordHash: String): Int {
        return dao.validate(username, passwordHash)
    }

    override suspend fun insertUser(user: User) {
        return dao.insertUser(user)
    }

    override suspend fun delete(user: User) {
        return dao.delete(user)
    }

    override suspend fun getUserFromUsername(username: String): User? {
        return dao.getUserByUsername(username)
    }
}