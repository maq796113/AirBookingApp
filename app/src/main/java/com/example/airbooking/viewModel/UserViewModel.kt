package com.example.airbooking.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbooking.UserUseCases
import com.example.airbooking.booking_feature.UserUniqueUsernameState
import com.example.airbooking.booking_feature.UserValidationState
import com.example.airbooking.events.UserEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    private val _isValid = mutableStateOf(UserValidationState())
    val isValid: State<UserValidationState> = _isValid

    private val _isUnique = mutableStateOf(UserUniqueUsernameState())
    val isUnique: State<UserUniqueUsernameState> = _isUnique

    private var value: Any? = null

    fun onEvent(event: UserEvent): Any? {

        when(event) {
            is UserEvent.ValidateUser -> {
                _isValid.value = isValid.value.copy(
                     state =
                )

                viewModelScope.launch {
                    value = userUseCases.validateUser()
                }
                return value

            }
            is UserEvent.UniqueUsername -> {
                _isUnique.value = isUnique.value.copy(
                    state=
                )
                viewModelScope.launch {
                    value = userUseCases.uniqueUsername
                }
                return value

            }
            is UserEvent.DeleteUser -> {
                viewModelScope.launch {
                    userUseCases.deleteUser
                }
            }
            is UserEvent.EnterUser -> {
                viewModelScope.launch {
                    userUseCases.enterUser
                }
            }

        }
        return null
    }
}