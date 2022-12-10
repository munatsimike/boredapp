package nl.project.bored.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import nl.project.bored.data.BoredRepository
import nl.project.bored.state.NetworkState
import javax.inject.Inject

@HiltViewModel
class BoredViewModel @Inject constructor(private val boredRepository: BoredRepository) :
    ViewModel() {

    private val _activity: MutableStateFlow<NetworkState> =
        MutableStateFlow(NetworkState.NotLoading)
    val activity: StateFlow<NetworkState> = _activity

    init {
        viewModelScope.launch {
            fetchActivity()
            collectActivity()
        }
    }

     private suspend fun collectActivity() {
        _activity.value = NetworkState.Loading
        boredRepository.activity.collectLatest {
            _activity.value = NetworkState.NetworkSuccess(it)

        }
    }

    suspend fun fetchActivity(){
        boredRepository.getActivity()
    }
}
