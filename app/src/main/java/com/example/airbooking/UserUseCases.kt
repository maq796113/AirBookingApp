package com.example.airbooking


import com.example.airbooking.usecase.DeleteUser
import com.example.airbooking.usecase.EnterUser
import com.example.airbooking.usecase.UniqueUsername
import com.example.airbooking.usecase.ValidateUser

data class UserUseCases(
    val deleteUser: DeleteUser,
    val uniqueUsername: UniqueUsername,
    val validateUser: ValidateUser,
    val enterUser: EnterUser
)
