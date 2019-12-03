package ams

import java.text.DateFormatSymbols
import java.util.*

val _weekdays = DateFormatSymbols().weekdays

val _randomFortunes: Array<String> = arrayOf(
    "You will have a great day!",
    "Things will go well for you today.",
    "Enjoy a wonderful day of success.",
    "Be humble and all will turn out well.",
    "Today is a good day for exercising restraint.",
    "Take it easy and enjoy life!",
    "Treasure your friends because they are your greatest fortune."
)

fun dayOfWeek(): String {
    println("What day is it today?")
    return _weekdays.get(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))
}

fun getFortuneCookie(): String {
    println("Enter your birthday: ")
    val dob = readLine()!!.trim().toIntOrNull() ?: -1
    val idx: Int = dob.div(_randomFortunes.size).rem(_randomFortunes.size)
    return if ((dob > -1) && (dob < 31)) _randomFortunes[idx] else "Choose something VALID Bitch!!"
}

/**
 * fitMoreFish function
 * Create a function that takes these arguments:

- tankSize (in gallons)
- currentFish (a list of Ints representing the length of each fish currently in the tank)
- fishSize (the length of the new fish we want to add to the tank)
- hasDecorations (true if the the tank has decorations, false if not)
 */
fun fitMoreFish(
    tankSize: Double,
    currentFish: Array<Int> = arrayOf(),
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
    val availableSpace: Double = if (hasDecorations) tankSize * 0.8 else tankSize
    return (availableSpace.toInt() - currentFish.sum() - fishSize) > -1
}

fun main() {
    val t = readLine()!!.trim().toIntOrNull() ?: -1
    println(if ((t > -1) && (t < 13)) "Good morning, Kotlin" else if (t < 24) "Good night, Kotlin" else "Invalid Time")
    println(dayOfWeek())
    println(message = getFortuneCookie())
    println(fitMoreFish(10.0, arrayOf(3, 3, 3)))
    println(fitMoreFish(8.0, arrayOf(2, 2, 2), hasDecorations = false))
    println(fitMoreFish(9.0, arrayOf(1, 1, 3), 3))
    println(fitMoreFish(10.0, arrayOf(), 7, true))
}
