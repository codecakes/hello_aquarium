package ams.Games

/**
 * Create an enum class, Directions,
 * that has the directions NORTH, SOUTH, EAST and WEST,
 * as well as START, and END.
 * Create a class Game.
Inside Game, declare a var, path, that is a mutable list of Direction.

Initialize it with one element, START.
Create 4 lambdas, north, south, east, and west,
that add the respective direction to the path.

Add another lambda, end, that:
Adds END to path
Prints “Game Over”
Prints the path
Clears the path
Returns false
Create a main function.
Inside main(), create an instance of Game.
To test your code so far, in main() print the path,
then invoke north, east, south, west, and end. Finally, print the path again.
 */

enum class Direction(val dir: Char) {
    NORTH('n'),
    EAST('e'),
    SOUTH('s'),
    WEST('w'),
    START('1'),
    END('0');
}

val directionVal = Direction.values().map { it.dir }

interface GameDirection {
    val direction: Direction
}

interface Path {
    val pathChart: String
}

interface Move {
    fun makeMove()
}

object StartDirection : GameDirection {
    override val direction: Direction = Direction.START
}

internal class Game(
    private var path: MutableList<Direction> = mutableListOf(StartDirection.direction)
) : Path, Move {

    override val pathChart: String
        get() = path.joinToString(separator = "->")

    private val start = {
        if (path.isNullOrEmpty()) {
            path.add(Direction.START)
        }
    }

    private val north = {
        path.add(Direction.NORTH)
    }
    private val east = {
        path.add(Direction.EAST)
    }

    private val south = {
        path.add(Direction.SOUTH)
    }

    private val west = {
        path.add(Direction.WEST)
    }

    private val end: () -> Boolean = {
        path.add(Direction.END)
        println("GAME OVER")
        println("Path: $pathChart")
        path.clear()
        false
    }

    private inline fun move(dir: Char, where: (Char) -> Unit) {
        where(dir)
    }

    /**
     * Inside makeMove, test whether the String is any of the 4 directions and
     * invoke move() with the corresponding lambda. Otherwise, invoke move() with end.
     */
    override fun makeMove() {
        print("Enter a direction: n/s/e/w:")
        (readLine()!!.trim().toCharArray().takeIf { it.isNotEmpty() }?.first() ?: '0')
            .takeIf { x: Char -> x.isLetter() }?.let {
                move(it) { d ->
                    when (d) {
                        'n' -> north()
                        'e' -> east()
                        's' -> south()
                        'w' -> west()
                        else -> {
                            end()
                            start()
                        }
                    }
                }
            }
    }
}

internal val initGame: () -> Game = { Game() }