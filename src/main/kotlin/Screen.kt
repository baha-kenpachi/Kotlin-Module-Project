import java.util.Scanner

abstract class Screen() {
    var menu: MutableMap<String, () -> Unit> = mutableMapOf()
    var runner = true

    protected val scanner: Scanner = Scanner(System.`in`)
    open fun updateMenu() {
    }

    fun iteratorForShowMenu(){
        updateMenu()
        menu.forEach { t, u -> println(t) }
    }
    abstract fun showMenu()

    abstract fun handleInput(input: String)
    fun action(
        menuType: Screen,
    ) { //принимает функцию для запуска экрана и предыдущий экран
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
        runner = false
    }
}
