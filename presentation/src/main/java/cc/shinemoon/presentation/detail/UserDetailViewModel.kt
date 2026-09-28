package cc.shinemoon.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.shinemoon.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UserDetailUiState>(UserDetailUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadUserDetail(login: String) {
        _uiState.value = UserDetailUiState.Loading

        viewModelScope.launch {
            userUseCase.detail(login)
                .collect { result ->
                    result.fold(
                        onSuccess = { userDetail ->
                            _uiState.value = UserDetailUiState.Success(userDetail)
                        },
                        onFailure = { exception ->
                            _uiState.value = UserDetailUiState.Error(exception.message ?: "Unknown error")
                        }
                    )
                }
        }
    }
}