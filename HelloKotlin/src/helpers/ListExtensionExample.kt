package helpers

fun main()
{
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.divisibleBy { it % 3 })
    println(numbers.divisibleByProper(3))
}


fun List<Int>.divisibleBy(block: (Int) -> Int) : List<Int>
{
    val result = mutableListOf<Int>()
    for (i in this)
    {
        if(block(i) == 0)
        {
            result.add(i)
        }
    }
    return result
}

fun List<Int>.divisibleByProper(divider: Int): List<Int>
{
    val result = mutableListOf<Int>()
    for (item in this)
    {
        if (item % divider == 0)
        {
            result.add(item)
        }
    }
    return result
}