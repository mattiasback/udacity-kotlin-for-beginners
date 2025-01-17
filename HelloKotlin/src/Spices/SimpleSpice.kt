package spices

import java.util.*
import helpers.*

fun main(args: Array<String>)
{
    var spice = SimpleSpice()
    println(spice.name + " has a heat of " + spice.heat)

    val spices = listOf(
        Spice2("curry") ,
        Spice2("pepper"),
        Spice2("cayenne", "hot"),
        Spice2("ginger"),
        Spice2("red curry", "hot"),
        Spice2("green curry", "hot"),
        Spice2("red pepper"),
        makeSalt())

    val spicy = spices.filter { s -> s.heat > 5 }
    val lessSpicy = spices.filter { s -> s.heat <= 5 }

    var spicesReversedCustomBad = reverseListBad(spices)
    for (spice in spicesReversedCustomBad)
    {
        println("BAD SPICY " + spice.stringRepresentation())
    }

    var spicesReversedCustomGood = reverseListGood(spices)
    for (spice in spicesReversedCustomGood)
    {
        println("GOOD SPICY " + spice.stringRepresentation())
    }

    var spiceReversedCustomBest = reverseListBest(spices)
    for (spice in spiceReversedCustomBest)
    {
        println("BEST SPICY " + spice.stringRepresentation())
    }
}


class SimpleSpice()
{
    val name: String = "curry"
    val spiciness: String = "mild"

    val heat: Int
        get() = 5
}

class Spice2(val name: String, val spiciness: String = "mild")
{
    val heat: Int
        get()
        {
            return when (spiciness.toLowerCase()) {
                "mild" -> 5
                "hot" -> 10
                else -> 0
            }
        }

    init {
        println(stringRepresentation())
    }

    fun stringRepresentation() : String
    {
        return "${this.name} ${this.spiciness} ${this.heat}"
    }
}

fun makeSalt() = Spice2("Salt")

