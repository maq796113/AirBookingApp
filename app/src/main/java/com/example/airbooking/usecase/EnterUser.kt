package com.example.airbooking.usecase

import com.example.airbooking.data.User
import com.example.airbooking.data.UserRepository

class EnterUser(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}