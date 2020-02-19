package books

fun main(args: Array<String>)
{
    val book = Book("Moby Dick", "Charles Dickens")
    println(book.readPage())
    println(book.readPage())
    println(book.readPage())

    val eBook = eBook()
    println(eBook.readPage())
    println(eBook.readPage())
    println(eBook.readPage())

    val (title, author) = book.getTitleAndAuthor()
    val (title2, author2, year) = book.getTitleAndAuthorAndYear()

    println("${title} ${author}")
    println("${title2} ${author2} ${year}")
}

open class Book(val title: String = "Oliver Twist", val author: String = "Charles Dickens", val year: Int = 1839)
{
    private var currentPage = 1

    open fun readPage(): Int {
        currentPage++
        return currentPage
    }

    fun getTitleAndAuthor(): Pair<String, String>
    {
        return Pair(title, author)
    }

    fun getTitleAndAuthorAndYear(): Triple<String, String, Int>
    {
        return Triple(title, author, year)
    }
}

class eBook(val format: String = "text") : Book()
{

    private var wordsRead = 0

    override fun readPage(): Int {
        wordsRead += 250
        return wordsRead
    }
}