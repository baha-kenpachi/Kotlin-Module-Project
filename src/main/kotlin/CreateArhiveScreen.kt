
class CreateArchiveScreen(private val archiveMenu: ArchiveMenu) {
    fun showScreen() {
        println("=== Создание архива ===")
        println("Введите название нового архива:")
    }

    fun handleInput(input: String) {
        val archiveName = input.trim()
        if (archiveName.isEmpty()) {
            println("Ошибка: название архива не может быть пустым.")
            //archiveMenu.showMenu()
        } else {
            archiveMenu.createArchive(archiveName)


        }
    }

}

