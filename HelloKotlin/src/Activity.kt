fun main(args: Array<String>)
{
    println(whatShouldIDoToday("happy"))
    println(whatShouldIDoToday("sad"))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String
{
    return when
    {
        mood == "happy" && weather == "sunny" -> "go for a walk"
        else -> "Stay home and read."
    }
}
