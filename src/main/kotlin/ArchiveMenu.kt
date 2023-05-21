import model.Archive

class ArchiveMenu : Screen(null) {

    private val createArchiveScreen: CreateArchiveScreen = CreateArchiveScreen(this)
    var menu: MutableMap<String, () -> Unit> = mutableMapOf()
    override fun updateMenu() {
        // функция updateMenu для обновления изменяемого списока, который содержит в себе название пункта и лямбду, которая вызовется при выборе этого пункта.
        menu = mutableMapOf()
        menu.put("0. Создать архив", { showCreateArchiveScreen() })
        val archives = Data.getAllArchives()
        for (i in archives.indices) {
            menu.put("${i + 1}. ${archives[i].archiveName}", { selectArchive(archives[i]) })
        }
        menu.put("${Data.getAllArchives().size + 1}. Выход", { exit() })

    }

    override fun showMenu() { // функция выводит через итерацию каждую строку списка
        println("Список архивов:")
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

    private fun showCreateArchiveScreen() {
        createArchiveScreen.showScreen()
        val input = scanner.nextLine()
        createArchiveScreen.handleInput(input)
    }

    fun createArchive(archiveName: String) {
        if (Data.getArchiveByName(archiveName) != null) {
            println("Ошибка: архив '$archiveName' уже существует.")
        } else {
            Data.addArchive(Archive(archiveName))
            println("Архив '$archiveName' создан.")
        }

    }

    private fun selectArchive(archive: Archive) {
        val archiveName = archive.archiveName
        println("Вы выбрали архив '$archiveName'.")
        val noteMenu = NoteMenu(archiveName, archive) // добавил второй параметр archive
        val archiveMenu = ArchiveMenu()
        noteMenu.action(noteMenu, archiveMenu)
    }

    override fun exit() {
        println("Выход из программы.")
        System.exit(0)
    }
}


