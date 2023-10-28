package com.example.airbooking.events

import com.example.airbooking.data.User

sealed interface UserEvent {
    data class EnterUser(val username: String?, val passwordHash: String?): UserEvent
    data class ValidateUser(val user: User): UserEvent
    data class DeleteUser(val user: User): UserEvent
    data class UniqueUsername(val username: String?): UserEvent

}