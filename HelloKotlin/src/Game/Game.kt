package game

fun main(args: Array<String>)
{
    val game = Game()
    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
    println(game.path)
}

enum class Directions{
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game
{
    val path = mutableListOf(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val west = { path.add(Directions.WEST) }
    val east = { path.add(Directions.EAST) }
    val end = {
        path.add(Directions.END)
        println("GAME OVER")
        println(path)
        path.clear()
        false
    }
}