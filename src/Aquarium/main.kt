package ams.Aquarium

fun main() {
    val myAquarium = Aquarium()
    println(myAquarium.length)
    println(myAquarium.volume)
    myAquarium.volume = 6.0F
    println(myAquarium.volume)
}