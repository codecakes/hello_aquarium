package ams.Spices

interface SpiceColor {
    var color: String
}

abstract class Spice(
    private var _name: String,
    private var _spiciness: String = "mild",
    color: SpiceColor
) : SpiceColor by color {
    val levels: Array<Int> = arrayOf(0, 1, 2, 3)
    val name: String
        get() = this._name

    abstract fun prepareSpice()

    companion object {
        val levelName: ArrayList<String>
            get() = arrayListOf(
                "bland",
                "mild",
                "hot",
                "kiss-my-ass"
            )
    }
}

object YellowSpiceColor : SpiceColor {
    override var color: String = "yellow"
}

interface Grinder {
    fun grind()
}

class Curry(
    private var _name: String,
    private var _spiciness: String,
    private var _color: SpiceColor = YellowSpiceColor
) : Spice(_name, _spiciness, _color), Grinder {
    override fun prepareSpice() {
        println(this._spiciness)
        println("${this._name}\'s color is: $color")
    }

    override fun grind() {
        val idx = Companion.levelName.indexOf(_spiciness)
        if (idx < 0) {
            println("${this._spiciness} is invalid spiciness.")
        } else {
            println(
                """Grind it! Spiciness: ${this._spiciness}
                    |Spice rating: ${Companion.levelName[idx]} 
                    |Spice color: ${this._color.color}
                """.trimMargin()
            )
        }
    }
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}