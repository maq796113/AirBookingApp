package com.example.airbooking.usecase

import com.example.airbooking.data.UserRepository

class ValidateUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(username: String, passwordHash: String): Int {
        return repository.validate(username, passwordHash)
    }
}