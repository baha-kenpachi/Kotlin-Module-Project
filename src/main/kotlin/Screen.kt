import java.util.Scanner

abstract class Screen(
    var previousScreen: Screen?
) {
//    open val allItem: MutableMap<String, MutableMap<String, Note>?> = mutableMapOf()
//    open val archives: MutableList<String> = mutableListOf()
//
//    abstract val notes: MutableMap<String, Note>
    fun showScreen(previousScreen: Screen) {
        action(previousScreen, null)
    }

    protected val scanner: Scanner = Scanner(System.`in`)

    abstract fun showMenu()

    abstract fun handleInput(input: String)

    fun action(menuType: Screen, previousType: Screen?){
        previousScreen = previousType
        while (true) {

            menuType.showMenu()
            val input = readLine()?.trim()
            if (input.equals("exit", ignoreCase = true)) {
                break
            }
            if (input != null) {
                menuType.handleInput(input)
            }
        }
    }
    open fun exit() {
        if (previousScreen != null) {
            showScreen(previousScreen!!)

        }
    }
}

open class ArchivesStructure {
    companion object {
        val mapOfArchiveNotes: MutableMap<String, MutableMap<String, String>> = mutableMapOf()

        val archives: MutableList<String> = mutableListOf()

        val notes: MutableMap<String, Note> = mutableMapOf()
    }



}