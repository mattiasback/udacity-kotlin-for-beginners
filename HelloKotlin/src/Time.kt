
fun main(args: Array<String>)
{
    println("Hour of day: ${args[0]}")
    var hour = args[0].toInt()
    hourOfDay(hour)
}

fun hourOfDay(hour: Int)
{
    println("Good ${if (hour < 12) "morning" else "night"}" )
}