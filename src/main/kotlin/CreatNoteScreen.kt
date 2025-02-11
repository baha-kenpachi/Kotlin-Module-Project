import model.Note
import java.util.*

class CreateNoteScreen(private val notesScreen: NotesScreen) {
    private val scanner: Scanner = Scanner(System.`in`)
    fun showScreen() {
        println("\n=== Создание заметки ===")
        println("Введите название новой заметки:")
    }

    fun handleInput(input: String) {
        val note: Note
        val noteName = input.trim()
        if (noteName.isEmpty()) {
            println("Ошибка: название заметки не может быть пустым.")
            notesScreen.showMenu()
        } else {
            println("Введите содержимое заметки:")
            val noteContent = scanner.nextLine()
            note = Note(noteName, noteContent)
            notesScreen.createNote(note)
        }
    }
}

