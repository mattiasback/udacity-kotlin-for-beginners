fun main(args: Array<String>)
{
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    val curries = getCurries(spices)
    println(curries)

    val startWithCEndWithE = getStartWithCEndWithE(spices)
    println(startWithCEndWithE)
    
    println(getFirstThreeStartsWithC(spices))
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
    return spices.subList(0, 2).filter { s -> s.startsWith('c')}
}