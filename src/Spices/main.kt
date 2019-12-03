package ams.Spices

fun main() {
    val curry = Curry("degi mirach", "hot")
    curry.grind()
    val spices = arrayOf(
        SpiceContainer(curry),
        SpiceContainer(Curry("sambhara miraachi", "mild"))
    )
    spices.forEach {
        println("Spice name: ${it.label}")
    }
}