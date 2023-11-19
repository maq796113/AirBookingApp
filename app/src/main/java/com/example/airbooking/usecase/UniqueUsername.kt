package com.example.airbooking.usecase

import com.example.airbooking.data.UserRepository

class UniqueUsername(
    private val repository: UserRepository
) {
    suspend operator fun invoke(username: String): Int {

        return repository.checkIfUsernameExists(username)
    }
}