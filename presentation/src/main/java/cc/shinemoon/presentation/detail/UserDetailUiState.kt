package cc.shinemoon.presentation.detail

import cc.shinemoon.domain.model.UserDetailModel

sealed class UserDetailUiState {
    object Loading : UserDetailUiState()
    data class Success(val userDetail: UserDetailModel) : UserDetailUiState()
    data class Error(val message: String) : UserDetailUiState()
}
