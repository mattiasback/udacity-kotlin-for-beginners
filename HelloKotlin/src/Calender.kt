import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

fun main(args: Array<String>)
{
    println("Hello, ${args[0]}")
    dayOfWeek()
}

fun dayOfWeek()
{
    println("What day is it today?")

    var date = LocalDate.now()
    var dow = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
    println("It is $dow")

    var day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println( when (day)
    {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"
    })
}