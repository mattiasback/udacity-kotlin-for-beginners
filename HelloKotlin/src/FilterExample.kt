fun main(args: Array<String>)
{
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    val curries = getCurries(spices)
    println(curries)

    val startWithCEndWithE = getStartWithCEndWithE(spices)
    println(startWithCEndWithE)
    
    println(getFirstThreeStartsWithC(spices))
    println(getFirstThreeStartsWithC2(spices))
}

fun getCurries(spices: List<String>) : List<String>
{
    return spices.filter { s -> s.contains("curry") }
}

fun getStartWithCEndWithE(spices: List<String>) : List<String>
{
    return spices.filter { s -> s.startsWith('c') && s.endsWith('e') }
}

fun getFirstThreeStartsWithC(spices: List<String>) : List<String>
{
    //End index is exclusive in sublist
    return spices.subList(0, 3).filter { s -> s.startsWith('c') }
}

fun getFirstThreeStartsWithC2(spices: List<String>) : List<String>
{
    return spices.take(3).filter { s -> s.startsWith('c') }
}