package nl.project.bored.state

import nl.project.model.ApiResponse

sealed class NetworkState {
    object NotLoading : NetworkState()
    object Loading : NetworkState()
    class NetworkError(val error: String) : NetworkState()
    class NetworkSuccess(val activity: ApiResponse) : NetworkState()
}