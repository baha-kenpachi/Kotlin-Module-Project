
import java.util.*

class NoteMenu(
    private val archiveName: String?

): Screen(ArchiveMenu()) {

    //val archiveMenu= ArchiveMenu()
    override fun showMenu() {
        println("Список заметок в архиве '$archiveName':")
        println("0. Создать заметку")
        var index = 1
        for (noteName in Data.notes.keys) { // цикл вынести в отдельную функцию IterateNoteList
            println("$index. $noteName")
            index++
        }
        println("${Data.notes.size + 1}. Выход")
    }

    override fun handleInput(input: String) {
        when (input) {
            "0" -> showCreateNoteScreen()
            "${Data.notes.size + 1}" -> exit()
            else -> {
                val noteIndex =
                    input.toIntOrNull() //нужно в notes.keys проитерировать и сравнивать индекс и input, если будет одинаково то через selectNote перейти в экран просмотра заметки
                if (noteIndex != null && noteIndex in 1..Data.notes.size) {
                    val noteName = Data.notes.keys.elementAt(noteIndex-1)
                    selectNote(noteName, Data.notes.getOrDefault(noteName, defaultValue = "Mistake"))//
                } else {
                    println("Ошибка: введите число из списка.")
                }
            }
        }
    }

    private fun showCreateNoteScreen() {
        val createNoteScreen = CreateNoteScreen(this)
        createNoteScreen.showScreen()
        val input = scanner.nextLine()
        createNoteScreen.handleInput(input)
    }

    fun createNote(noteName: String, noteContent: String) {
        Data.notes[noteName] = noteContent
        println("Заметка '$noteName' создана.")
        //showMenu()
    }

    private fun selectNote(
        noteName: String,
        noteContent: String
    ) {

        println("Вы выбрали заметку '$noteName'.")
        val note = Note(noteName, noteContent)
        //val archiveMenu= ArchiveMenu()
        val noteMenu = NoteMenu(archiveName)
        note.action(note, noteMenu)
        // Действия при выборе заметки
    }
}