package ams.spice

class Spice(private var _name: String, private var _spiciness: String = "mild") {
    private val levels: Array<Int> = arrayOf(0, 1, 2, 3)

    val name: String
        get() = this._name

    val heat: Int
        get() {
            return if (levelName.contains(this._spiciness)) {
                this.levels[levelName.indexOf(this._spiciness)]
            } else -1
        }

    companion object {
        private val levelName: ArrayList<String>
            get() = arrayListOf(
                "bland",
                "mild",
                "hot",
                "kiss-my-ass"
            )
    }
}