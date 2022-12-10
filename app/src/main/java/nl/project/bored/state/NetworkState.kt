package nl.project.bored.state

import nl.project.model.Activity

sealed class NetworkState {
    object NotLoading : NetworkState()
    object Loading : NetworkState()
    class NetworkError(val error: String) : NetworkState()
    class NetworkSuccess(val activity: Activity) : NetworkState()
}