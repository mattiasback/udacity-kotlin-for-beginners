package helpers


fun <T> reverseListBad(list: List<T>): List<T> where T : Any {

    val result = mutableListOf<T>()

    for (i in list.indices) {
        result.add(list[list.size - 1 - i])
    }

    return result
}

fun <T> reverseListGood(list: List<T>): List<T> where T : Any {

    val result = mutableListOf<T>()

    for (i in list.size - 1 downTo 0) {
        result.add(list[i])
    }

    return result
}

fun <T> reverseListBest(list: List<T>): List<T> where T : Any {

    return list.asReversed()
}
