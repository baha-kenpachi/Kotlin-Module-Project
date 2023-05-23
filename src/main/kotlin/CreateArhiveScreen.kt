
class CreateArchiveScreen(private val archiveScreen: ArchiveScreen) {
    fun showScreen() {
        println("\n=== Создание архива ===")
        println("Введите название нового архива:")
    }

    fun handleInput(input: String) {
        val archiveName = input.trim()
        if (archiveName.isEmpty()) {
            println("Ошибка: название архива не может быть пустым.")
        } else {
            archiveScreen.createArchive(archiveName)
        }
    }

}

