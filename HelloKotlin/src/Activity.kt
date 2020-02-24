fun main(args: Array<String>)
{
    print("\nEnter your mood: ")
    var mood: String = readLine() ?: "unknown"

    println(whatShouldIDoToday(mood))
    println(whatShouldIDoToday(mood, "rainy", -1))
    println(whatShouldIDoToday(mood, temperature = 40))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String
{
    return when
    {
        isHappySunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isTooHot(temperature) -> "go swimming"
        else -> "stay home and read."
    }
}

fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature <= 0
fun isTooHot(temperature: Int) = temperature > 35
