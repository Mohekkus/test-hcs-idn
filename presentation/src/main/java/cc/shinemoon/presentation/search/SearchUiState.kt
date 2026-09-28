package cc.shinemoon.presentation.search

import cc.shinemoon.domain.model.UserModel

sealed class SearchUiState {
    object Idle : SearchUiState()

    object Loading : SearchUiState()

    data class Success(val users: List<UserModel>) : SearchUiState()

    data class Error(val message: String) : SearchUiState()

    object Empty : SearchUiState()
}