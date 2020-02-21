package books

const val MAXIMUM_NUMBER_OF_BOOKS = 10

object Constants
{
    val BASE_URL = "library/books/"
}

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

    //Author Charles Dickens
    val allBooks = setOf(
        Book("Oliver Twist", year = 1839),
        Book("David Copperfield", year = 1850),
        Book("Bleak House", year = 1853)
    )

    var library = mapOf("Charles Dickens" to allBooks)

    val isOliverTwistReturned = library.any { author -> author.value.any { book -> book.title == "Oliver Twist" } }
    println("Oliver Twist is returned: $isOliverTwistReturned")

    var moreBooks = mutableMapOf("Shakespeare" to "Hamlet")
    moreBooks.getOrPut("Shakespeare") { "Hamlet" }
    moreBooks.put("Shakespeare", "Romeo and Juliet")

    println(moreBooks)

    book.printUrl()
}

open class Book(val title: String = "Oliver Twist", val author: String = "Charles Dickens", val year: Int = 1839, var pages: Int = 500)
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

    fun canBorrow(numBorrowedBooks: Int): Boolean
    {
        return numBorrowedBooks < MAXIMUM_NUMBER_OF_BOOKS
    }

    fun printUrl()
    {
        println("${BASE_URL}${title.filter { c -> c != ' ' }}.html")
    }

    companion object Constants
    {
        const val BASE_URL = "library/books/"
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

//2.1 grams per page
fun Book.weight(): Double = pages*2.1

fun Book.tornPages(torn: Int): Int {
    pages -= torn
    return pages
}