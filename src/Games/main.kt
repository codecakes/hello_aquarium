package ams.Games

fun main() {
    val g = initGame()
    println(g.pathChart)
//    g.east()
//    g.west()
//    g.end()

}

val filterBy3: (Int) -> Boolean = { it.rem(3) == 0 }

fun List<Int>.divisibleBy3(cb: (Int) -> Boolean): List<Int> {
    return this.filter(cb)
}
