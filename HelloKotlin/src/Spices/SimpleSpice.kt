package Spices

fun main(args: Array<String>)
{
    var spice = SimpleSpice()
    println(spice.name + " has a heat of " + spice.heat)

    val spices = listOf(
        Spice("curry") ,
        Spice("pepper"),
        Spice("cayenne", "hot"),
        Spice("ginger"),
        Spice("red curry", "hot"),
        Spice("green curry", "hot"),
        Spice("red pepper"),
        makeSalt())

    val spicy = spices.filter { s -> s.heat > 5 }
    val lessSpicy = spices.filter { s -> s.heat <= 5 }

    for (spice in spicy)
    {
        println("SPICY " + spice.stringRepresentation())
    }
    for (spice in lessSpicy)
    {
        println("LESS SPICY " + spice.stringRepresentation())
    }
}


class SimpleSpice()
{
    val name: String = "curry"
    val spiciness: String = "mild"

    val heat: Int
        get() = 5
}

class Spice(val name: String, val spiciness: String = "mild")
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

fun makeSalt() = Spice("Salt")

