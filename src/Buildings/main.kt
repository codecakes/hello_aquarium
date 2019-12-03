package ams.Buildings

fun main() {
    val b = Building(Wood())
    b.build()
    val c = Building(Brick())
    c.build()
    println(isSmallBuilding(c))
}