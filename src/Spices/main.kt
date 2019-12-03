package ams.Spices

fun main() {
    val curry = createCurry("degi mirach", "hot")
    curry.grind()
    val spices = arrayOf(
        SpiceContainer(curry),
        SpiceContainer(
            createCurry(
                "sambhara miraachi",
                "mild",
                RedSpiceColor
            )
        )
    )
    spices.forEach {
        println("Spice name: ${it.label}")
        it.spice.grind()
    }
}