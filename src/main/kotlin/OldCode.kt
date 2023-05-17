
open class Data() {
    companion object ArchiveList {
        val allItem: MutableMap<String, MutableMap<String, Note>?> = mutableMapOf()
        val archives: MutableList<String> = mutableListOf()
        val notes: MutableMap<String, String> = mutableMapOf()

    }
}
/*
class OldCode {
}
class ArchiveMenu : Screen() {
    private val archives: MutableList<String> = mutableListOf()
    private val createArchiveScreen: CreateArchiveScreen = CreateArchiveScreen(this)

    fun showMenu() {
        println("Список архивов:")
        println("0. Создать архив")

        for (i in archives.indices) {
            println("${i + 1}. ${archives[i]}")
        }
        println("${archives.size + 1}. Выход")
    }

    override fun handleInput(input: String) {
        when (input) {
            "0" -> showCreateArchiveScreen()
            "${archives.size + 1}" -> exit()
            else -> {
                val archiveIndex = input.toIntOrNull()
                if (archiveIndex != null && archiveIndex in 1..archives.size) {
                    selectArchive(archiveIndex - 1)
                } else {
                    println("Ошибка: введите число из списка.")
                }
            }
        }
    }

    private fun showCreateArchiveScreen() {
        createArchiveScreen.showScreen()
        val input = scanner.nextLine()
        createArchiveScreen.handleInput(input)
    }

    fun createArchive(archiveName: String) {
        if (archives.contains(archiveName)) {
            println("Ошибка: архив '$archiveName' уже существует.")
        } else {
            archives.add(archiveName)
            //mapOfArchiveNotes[archiveName] = mutableMapOf()
            println("Архив '$archiveName' создан.")
        }
    }

    private fun selectArchive(archiveIndex: Int) {
        val archiveName = archives[archiveIndex]
        println("Вы выбрали архив '$archiveName'.")
        //нужно реализовать переход в НотМеню

    }

    override fun exit() {
        println("Выход из программы.")
        System.exit(0)
    }
}

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
            //archiveMenu.showMenu()
        }
    }

}
*/
