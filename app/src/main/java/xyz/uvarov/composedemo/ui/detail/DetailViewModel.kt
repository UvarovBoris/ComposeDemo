package xyz.uvarov.composedemo.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import xyz.uvarov.composedemo.Repository
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(DetailState(0))
    val state: StateFlow<DetailState> = _state.asStateFlow()

    fun onCounterClick() {
        _state.update {
            it.copy(counter = it.counter + 1)
        }
    }
}