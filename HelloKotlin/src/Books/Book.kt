package books

fun main(args: Array<String>)
{
    val book = Book()
    println(book.readPage())
    println(book.readPage())
    println(book.readPage())

    val eBook = eBook()
    println(eBook.readPage())
    println(eBook.readPage())
    println(eBook.readPage())
}

open class Book {

    private var currentPage = 1

    open fun readPage(): Int {
        currentPage++
        return currentPage
    }
}

class eBook(val format: String = "text") : Book() {

    private var wordsRead = 0

    override fun readPage(): Int {
        wordsRead += 250
        return wordsRead
    }
}