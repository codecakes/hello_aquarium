package ams.Games

fun main() {
    val g = initGame()
    println(g.pathChart)
    g.makeMove()
    g.makeMove()
    g.makeMove()
    println(g.pathChart)
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    println(numbers.divisibleBy3(filterBy3))

}

val filterBy3: (Int) -> Boolean = { it.rem(3) == 0 }

inline fun List<Int>.divisibleBy3(cb: (Int) -> Boolean): List<Int> {
    return this.filter(cb)
}
