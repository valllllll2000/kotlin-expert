import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type {
        TEXT, AUDIO
    }
}

suspend fun getNotes(number: Int = 10): (List<Note>) = withContext(Dispatchers.IO) {
    delay(2000)
    (1..number).map {
        Note("Title $it", "Description $it", generateType(it))
    }
}

private fun generateType(index: Int): Note.Type {
    return when (index % 2) {
        0 -> Note.Type.TEXT
        else -> Note.Type.AUDIO
    }
}
