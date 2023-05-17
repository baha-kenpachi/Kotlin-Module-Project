import java.util.*

class CreateNoteScreen(private val noteMenu: NoteMenu) {
    private val scanner: Scanner = Scanner(System.`in`)
    //private val note: MutableMap<String, String> = mutableMapOf()
    fun showScreen() {
        println("=== Создание заметки ===")
        println("Введите название новой заметки:")
    }

    fun handleInput(input: String) {
        val noteName = input.trim()
        if (noteName.isEmpty()) {
            println("Ошибка: название заметки не может быть пустым.")
            noteMenu.showMenu()
        } else {
            println("Введите содержимое заметки:")
            val noteContent = scanner.nextLine()
            noteMenu.createNote(noteName, noteContent)
            Data.notes[noteName] = noteContent
        }
    }
}

