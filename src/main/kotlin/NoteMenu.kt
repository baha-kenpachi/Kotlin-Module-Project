import model.Archive
import model.Note

class NoteMenu(
    private val archiveName: String?,
    private val archive: Archive
) : Screen(ArchiveMenu()) {
    private val createNoteScreen: CreateNoteScreen = CreateNoteScreen(this)
    var menu: MutableMap<String, () -> Unit> = mutableMapOf()
    val notes = archive.notes


    override fun updateMenu() {
        menu = mutableMapOf()
        menu.put("0. Создать заметку", { showCreateNoteScreen() })
        //val notes = Data.getArchiveByName(archiveName!!)?.notes

        if (notes != null) {
            for (i in notes.indices) {
                menu.put("${i + 1}. ${notes[i].noteName}", { selectNote(notes[i].noteName, notes[i].noteContent) })
            }
            menu.put("${notes.size + 1}. Выход", { exit() })
        }
    }

    override fun showMenu() { // функция выводит через итерацию каждую строку списка
        println("Список заметок в '${archiveName}':")
        updateMenu()
        menu.forEach { t, u -> println(t) }
    }

    override fun handleInput(input: String) {

        val selected =
            menu.keys.find { // через find проходим по каждому ключу с 0 до 1 индекса ключа если данное значение совпадает с input то возвращаем ключ и присваеваем к selected
                it.substring(0, 1) == input
            } // если selected  не пустой то запускаем лямбда функцию по ключу мапы, котрую реализовали  в updateMenu
        if (selected == null) println("Ошибка: введите число из списка.") else menu[selected]?.invoke()
    }

    private fun showCreateNoteScreen() {
        createNoteScreen.showScreen()
        val input = scanner.nextLine()
        createNoteScreen.handleInput(input)
    }

    fun createNote(note: Note) {
        if (note.noteName == null) {
            println("Ошибка: заметка '${note.noteName}' уже существует.")
        } else {
            archive.notes.add(note)
//            Data.addArchive(Archive(archiveName!!, notes = mutableListOf(note)))  не понимаю как добавить (( не создавая новый йархив
            println("Заметка '${note.noteName}' создана.")
        }
    }

    private fun selectNote(name:String, content:String) {

        /*println("Вы выбрали заметку '${note.noteName}'.")*/
        val noteScreen = NoteScreen(name, content)
        val noteMenu = NoteMenu(archiveName, archive)
        noteScreen.action(noteScreen, noteMenu)

    }
}