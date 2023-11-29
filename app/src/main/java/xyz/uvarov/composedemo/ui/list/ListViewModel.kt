package xyz.uvarov.composedemo.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import xyz.uvarov.composedemo.Repository
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ListUiState(emptyList()))
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    init {
        updateItems()
    }

    private fun updateItems() {
        viewModelScope.launch {
            val newItems = repository.getItems()
            _uiState.update { it.copy(items = newItems) }
        }
    }
}