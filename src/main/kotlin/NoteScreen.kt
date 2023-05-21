import model.Note

class NoteScreen(name:String, content:String):Screen(ArchiveMenu()) {

    val name = name
    val content = content
    override fun showMenu() {

        println("Просмотр заметки ${name}:")
        println("0. Выход с просмотра заметки")
        println("============================")
        println("$content")
    }


    override fun handleInput(input: String) {
        when (input) {
            "0" -> exit()
            "${Data.getAllArchives().size + 1}" -> exit()
            else -> {
                println("Ошибка: введите число из списка.")
            }

        }
    }
}