package game

fun main(args: Array<String>)
{
    val game = Game()

    while(true)
    {
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
    }

}

enum class Directions{
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game(val gameMap: GameMap = GameMap())
{
    private val path = mutableListOf(Directions.START)

    private val north = { path.add(Directions.NORTH) }
    private val south = { path.add(Directions.SOUTH) }
    private val west = { path.add(Directions.WEST) }
    private val east = { path.add(Directions.EAST) }
    private val end = {
        path.add(Directions.END)
        println("GAME OVER")
        println(path)
        path.clear()
        false
    }

    private fun move(where: () -> Boolean)
    {
        where()
    }

    fun makeMove(direction: String?)
    {
        when (direction)
        {
            "n" -> {
                move(north)
                println(gameMap.updateLocation(Directions.NORTH))
            }
            "s" -> {
                move(south)
                println(gameMap.updateLocation(Directions.SOUTH))
            }
            "w" -> {
                move(west)
                println(gameMap.updateLocation(Directions.WEST))
            }
            "e" -> {
                move(east)
                println(gameMap.updateLocation(Directions.EAST))
            }
            else -> move(end)
        }
    }

}

class GameMap(val width: Int = 4, val height: Int = 4)
{
    private data class Position(var x: Int, var y: Int)
    private var playerPos: Position = Position(0,0)

    val map = Array(width) { arrayOfNulls<Tile>(height) }

    enum class Tile(val description: String)
    {
        PLAIN("plain"),
        MOUNTAIN("mountain"),
        HILL("hill"),
        CAVE("cave"),
        TOWN("town")
    }

    init
    {
        map[0][0] = Tile.PLAIN //North West
        map[0][1] = Tile.PLAIN
        map[0][2] = Tile.CAVE
        map[0][3] = Tile.MOUNTAIN
        map[1][0] = Tile.PLAIN
        map[1][1] = Tile.PLAIN
        map[1][2] = Tile.TOWN
        map[1][3] = Tile.PLAIN
        map[2][0] = Tile.PLAIN
        map[2][1] = Tile.HILL
        map[2][2] = Tile.HILL
        map[2][3] = Tile.HILL
        map[3][0] = Tile.CAVE
        map[3][1] = Tile.MOUNTAIN
        map[3][2] = Tile.PLAIN
        map[3][3] = Tile.TOWN //South East
    }

    fun updateLocation(direction: Directions) : String
    {
        var xMove = 0
        var yMove = 0

        when(direction)
        {
            Directions.NORTH -> yMove = -1
            Directions.SOUTH -> yMove = 1
            Directions.EAST -> xMove = 1
            Directions.WEST -> xMove = -1
        }

        if((playerPos.x + xMove) in 0 until width)
        {
            playerPos.x += xMove
        }

        if((playerPos.y + yMove) in 0 until height)
        {
            playerPos.y += yMove
        }

        return map[playerPos.x][playerPos.y]?.description ?: "Player out of bounds!"
    }
}