class ArchiveMenu : Screen(null) {

    private val createArchiveScreen: CreateArchiveScreen = CreateArchiveScreen(this)

    override fun showMenu() {
        println("Список архивов:")
        println("0. Создать архив")

        for (i in Data.archives.indices) {
            println("${i + 1}. ${Data.archives[i]}")
        }
        println("${Data.archives.size + 1}. Выход")
    }

    override fun handleInput(input: String) {
        when (input) {
            "0" -> showCreateArchiveScreen()
            "${Data.archives.size + 1}" -> exit()
            else -> {
                val archiveIndex = input.toIntOrNull()
                if (archiveIndex != null && archiveIndex in 1..Data.archives.size) {
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
        if (Data.archives.contains(archiveName)) {
            println("Ошибка: архив '$archiveName' уже существует.")
        } else {
            Data.archives.add(archiveName)
            Data.allItem[archiveName] = mutableMapOf() //у каждого архива теперь своя мапа
            println("Архив '$archiveName' создан.")
        }
    }

    private fun selectArchive(archiveIndex: Int) {
        val archiveName = Data.archives[archiveIndex]
        println("Вы выбрали архив '$archiveName'.")
        val noteMenu = NoteMenu(archiveName)
        val archiveMenu = ArchiveMenu()
        noteMenu.action(noteMenu, archiveMenu)

        //нужно реализовать переход в НотМеню

    }

    override fun exit() {
        println("Выход из программы.")
        System.exit(0)
    }
}


