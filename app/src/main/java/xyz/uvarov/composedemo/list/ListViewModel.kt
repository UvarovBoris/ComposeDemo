package xyz.uvarov.composedemo.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import xyz.uvarov.composedemo.Repository
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(ListState())
    val state: StateFlow<ListState> = _state.asStateFlow()
}