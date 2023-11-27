package xyz.uvarov.composedemo.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailViewModel : ViewModel() {

    private val _state = MutableStateFlow(DetailState(0))
    val state: StateFlow<DetailState> = _state.asStateFlow()

    fun onCounterClick() {
        _state.update {
            it.copy(counter = it.counter + 1)
        }
    }
}