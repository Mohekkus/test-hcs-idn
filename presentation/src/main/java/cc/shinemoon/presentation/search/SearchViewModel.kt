package cc.shinemoon.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cc.shinemoon.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow<String>("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<SearchUiEvent>(Channel.CONFLATED)
    val uiEvent = _uiEvent.receiveAsFlow()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun loadSearchQuery() {
        _searchQuery.value = "octocat"
    }

    fun searchUsers(query: String) {
        if (query.isBlank()) {
            _uiState.value = SearchUiState.Empty
            return
        }

        _uiState.value = SearchUiState.Loading

        viewModelScope.launch {
            searchUseCase.invoke(query)
                .catch { exception ->
                    _uiState.value = SearchUiState.Error(exception.message ?: "Unknown error")
                }
                .collect { result ->
                    result.fold(
                        onSuccess = { users ->
                            if (users.isEmpty()) {
                                _uiState.value = SearchUiState.Empty
                            } else {
                                _uiState.value = SearchUiState.Success(users)
                            }
                        },
                        onFailure = { exception ->
                            _uiState.value = SearchUiState.Error(exception.message ?: "Unknown error")
                        }
                    )
                }
        }
    }
}