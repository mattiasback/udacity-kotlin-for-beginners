import kotlin.random.Random

const val SIDES = 6

fun main(args: Array<String>)
{
    println("Hello, ${args[0]}")

    val rollDice = { sides:Int ->
        if (sides <= 0) 0
        else Random.nextInt(1, sides)
    }

    val rollDice2: (Int) -> Int = { sides ->
        if (sides <= 0) 0
        else Random.nextInt(1, sides)
    }

    for (i in 1..10)
    {
        gamePlay(rollDice2(SIDES))
    }
}

fun gamePlay(roll: Int)
{
    println(roll)
}