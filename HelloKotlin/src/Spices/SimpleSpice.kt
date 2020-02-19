package Spices

public class SimpleSpice()
{
    val name: String = "curry"
    val spiciness: String = "mild"

    val heat: Int
        get() = 5
}

fun main(args: Array<String>)
{
    var spice = SimpleSpice()
    println(spice.name + " has a heat of " + spice.heat)
}
