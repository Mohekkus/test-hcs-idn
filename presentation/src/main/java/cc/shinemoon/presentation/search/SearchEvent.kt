package cc.shinemoon.presentation.search

sealed class SearchUiEvent {
    data class NavigateToUserDetail(val login: String) : SearchUiEvent()
    data class ShowSnackbar(val message: String) : SearchUiEvent()
}