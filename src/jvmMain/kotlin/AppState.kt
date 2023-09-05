import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*

class AppState {
    var state by mutableStateOf(UiState())

    suspend fun loadNotes(coroutineScope: CoroutineScope) {
        state = UiState(loading = true)
        coroutineScope.launch {
            state = UiState(getNotes(), loading = false)
        }
    }
}

data class UiState(
    val notes: List<Note>? = null, val loading: Boolean = false
)
