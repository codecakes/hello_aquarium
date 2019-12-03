package ams.Aquarium

import kotlin.math.pow

class Aquarium {
    var length: Float = 20.0F

    var volume: Float
        get() = length.pow(3)
        set(value) {
            length = value
        }
}