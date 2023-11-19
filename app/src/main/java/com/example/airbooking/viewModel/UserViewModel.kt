package com.example.airbooking.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.airbooking.UserUseCases
import com.example.airbooking.booking_feature.UserUniqueUsernameState
import com.example.airbooking.booking_feature.UserValidationState
import com.example.airbooking.data.SessionCache
import com.example.airbooking.data.User
import com.example.airbooking.events.UserEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    private val sessionCache: SessionCache
) : ViewModel() {

    private val _isValid = mutableStateOf(UserValidationState())
    val isValid: State<UserValidationState> = _isValid

    private val _isUnique = mutableStateOf(UserUniqueUsernameState())
    val isUnique: State<UserUniqueUsernameState> = _isUnique

    private var value: Int? = null

    private val _userState = mutableStateOf(User())
    val userState: State<User>  = _userState

    val session get() = sessionCache



    fun onEvent(event: UserEvent) {
        when(event) {
            is UserEvent.ValidateUser -> {
                viewModelScope.launch {
                    value = userUseCases.validateUser(event.user.username!!, event.user.passwordHash!!)
                }
                _isValid.value = isValid.value.copy(
                    state = value
                )

            }
            is UserEvent.UniqueUsername -> {
                viewModelScope.launch {
                    value = userUseCases.uniqueUsername(event.username!!)
                }

                _isUnique.value = isUnique.value.copy(
                    state= value
                )
            }
            is UserEvent.DeleteUser -> {
                viewModelScope.launch {
                    userUseCases.deleteUser(event.user)
                }
            }
            is UserEvent.EnterUser -> {
                viewModelScope.launch {
                    userUseCases.enterUser(event.user)
                }
            }
            is UserEvent.GetUserByUsername -> {
                viewModelScope.launch {
                    _userState.value = userUseCases.getUserFromUsername(event.username)!!
                }
            }

        }
    }
}