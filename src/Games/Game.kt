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

enum class Direction(val dir: Int) {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3),
    START(4),
    END(5);
}

interface GameDirection {
    val direction: Direction
}

interface Path {
    val pathChart: String
}

object StartDirection : GameDirection {
    override val direction: Direction = Direction.START
}

internal class Game(
    private var path: MutableList<Direction> = mutableListOf(StartDirection.direction)
) : Path {

    override val pathChart: String
        get() = path.joinToString(separator = "->")

    val start = {
        if (path.isNullOrEmpty()) {
            path.add(Direction.START)
        }
    }

    val north = {
        path.add(Direction.NORTH)
    }
    val east = {
        path.add(Direction.EAST)
    }

    val south = {
        path.add(Direction.SOUTH)
    }

    val west = {
        path.add(Direction.WEST)
    }

    val end: () -> Boolean = {
        path.add(Direction.END)
        println("GAME OVER")
        println("Path: $pathChart")
        path.clear()
        false
    }
}

internal val initGame: () -> Game = { Game() }