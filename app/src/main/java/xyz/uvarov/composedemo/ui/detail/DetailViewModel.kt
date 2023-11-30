package xyz.uvarov.composedemo.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import xyz.uvarov.composedemo.Screen
import xyz.uvarov.data.Repository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState(null))
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    init {
        val id: Int = savedStateHandle.get<Int>(Screen.id)!!
        updateItem(id)
    }

    private fun updateItem(id: Int) {
        viewModelScope.launch {
            repository.getItem(id)?.let { item ->
                _uiState.update { it.copy(item = item) }
            }
        }
    }
}