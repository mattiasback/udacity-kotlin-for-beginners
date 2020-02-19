package spices

fun main(args: Array<String>)
{
    val curry = Curry("Yellow Curry", "mild")
    curry.prepareSpice()

    val sc1 = SpiceContainer(Curry("yellow", "mild"))
    val sc2 = SpiceContainer(Curry("green", "hot"))

    println(sc1.label)
    println(sc2.label)
}

enum class Color(val rgb: Int)
{
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0x0000FF)
}

abstract sealed class Spice(val name: String, val spiciness: String = "mild", color: ISpiceColor) : ISpiceColor by color
{

    private val heat: Int
        get()
        {
            return when (spiciness.toLowerCase())
            {
                "mild" -> 5
                "hot" -> 10
                else -> 0
            }
        }

    init
    {
        println(stringRepresentation())
    }

    fun stringRepresentation() : String
    {
        return "${this.name} ${this.spiciness} ${this.heat} ${this.color}"
    }

    open fun prepareSpice()
    {

    }
}

interface IGrinder
{
    fun grind()
}

interface ISpiceColor
{
    val color: Color
}

object YellowColor : ISpiceColor
{
    override val color = Color.YELLOW
}

class Curry(name: String,
            spiciness: String,
            color: ISpiceColor = YellowColor)
    : Spice(name, spiciness, color), IGrinder
{
    override fun prepareSpice()
    {
        grind()
    }

    override fun grind() {
        println("grinding...")
    }
}

data class SpiceContainer(val spice: Spice)
{
    val label: String = spice.name
}


