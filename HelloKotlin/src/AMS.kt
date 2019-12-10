import kotlin.random.Random

//Aquarium Management System

fun main(args: Array<String>)
{
    println("Hello, ${args[0]}!")
    for (i in 1..10)
    {
        feedTheFish()
    }
}

fun feedTheFish()
{
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day, feed the fish $food.")
}

fun randomDay(): String
{
    val week = listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week.random()
}

fun fishFood(day: String) : String
{
    var food = "fasting"

    when (day)
    {
        "Monday" -> food = "corn"
        "Tuesday" -> food = "pellets"
    }

    return food
}