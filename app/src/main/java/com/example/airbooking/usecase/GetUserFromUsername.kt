package com.example.airbooking.usecase
import com.example.airbooking.data.User
import com.example.airbooking.data.UserRepository


class GetUserFromUsername(
    private val repository: UserRepository
) {
    suspend operator fun invoke(username: String): User? {
        return repository.getUserFromUsername(username)
    }
}





