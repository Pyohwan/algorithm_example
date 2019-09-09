interface Clickable {
    fun click(); // 일반 메소드
    fun showOff() = println("I'm clickable!") // 디폴트 구현
}

class Button: Clickable {
    override fun click() = println("I was clicked")
    override fun showOff() {
        super<Clickable>.showOff();
    }
}

fun main() {
    val button = Button()
    button.showOff()
    button.click()
}