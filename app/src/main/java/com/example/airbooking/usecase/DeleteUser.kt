package com.example.airbooking.usecase

import com.example.airbooking.data.User
import com.example.airbooking.data.UserRepository

class DeleteUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        repository.delete(user)
    }
}