class Note(val noteName:String, val noteContent:String):Screen(ArchiveMenu()) {

    override fun showMenu() {
        println("Просмотр заметки ${noteName}:")
        println("0. Выход с просмотра заметки")
        println("============================")
        println("$noteContent")
    }


    override fun handleInput(input: String) {
        when (input) {
            "0" -> exit()
            "${Data.archives.size + 1}" -> exit()
            else -> {
                println("Ошибка: введите число из списка.")
            }

        }
    }
}