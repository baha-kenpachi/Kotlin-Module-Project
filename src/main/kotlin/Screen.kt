import java.util.Scanner

abstract class Screen(
    var previousScreen: Screen?
) {
    var runner = true
    fun showScreen(previousScreen: Screen) {
        action(previousScreen, null)
    }

    protected val scanner: Scanner = Scanner(System.`in`)
    open fun updateMenu() {
    }

    abstract fun showMenu()
    abstract fun handleInput(input: String)
    fun action(menuType: Screen, previousType: Screen?) { //принимает функцию для запуска экрана и предыдущий экран
        previousScreen = previousType

        while (runner) {
            updateMenu()
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
        runner =false
        /*if (previousScreen != null) {

            showScreen(previousScreen!!)
        }*/
    }
}
