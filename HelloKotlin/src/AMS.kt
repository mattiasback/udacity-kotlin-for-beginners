import java.util.function.Consumer
import kotlin.random.Random

//Aquarium Management System

fun main(args: Array<String>)
{
    println("Hello, ${args[0]}!")
    for (i in 1..10)
    {
        feedTheFish()
    }

    println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
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

fun canAddFish(gallons: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true) : Boolean
{
    var canFitFish = false

    var inchPerGallonRatio: Double = if(hasDecorations) 0.8 else 1.0

    var currentFishLength = 0
    for(i in currentFish)
    {
        currentFishLength += i
    }

    if((currentFishLength + fishSize) <= (gallons * inchPerGallonRatio))
    {
        canFitFish = true
    }

    return canFitFish
}