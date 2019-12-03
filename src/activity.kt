package ams

/**
 *
mood: a required string parameter
weather: a string parameter that defaults to "sunny"
temperature: an Integer parameter that defaults to 24 (Celsius).

 */
fun whatShouldIDoToday(mood: String, weather: String = "sunny"): String {
    return when {
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        else -> "Stay home and read."
    }

}

fun main() {
    println("How are you feeling")
    println(whatShouldIDoToday(readLine()!!.trim().toLowerCase()))
}