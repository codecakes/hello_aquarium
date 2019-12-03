package ams.Books

import java.time.Year

open class Book(private var _name: String, private var _author: String) {
    private var _pages: Int = 0
    private var _currentPage: Int = 1
    private var _year: Year = Year.now()

    open var pages: Int
        get() = this._pages
        set(value) {
            this._pages = pages
        }

    open fun readPage() {
        this._currentPage += 1
    }

    open var year: Year
        get() = this._year
        set(value) {
            this._year = value
        }


    fun setBookYear(year: Year) {
        this.year = year
    }

    fun info(): Pair<String, String> {
        return Pair(this._name, this._author)
    }

    fun moreInfo(): Triple<String, String, Year> {
        return Triple(this._name, this._author, this.year)
    }
}

fun Book.tornPages(torn: Int): Int {
    return if (this.pages >= torn) (this.pages - torn) else 0
}

class eBook(
    private var _name: String,
    private var _author: String,
    private var format: String = "text"
) : Book(_name, _author) {
    private var _words: Int = 0

    init {
        println("Books name: $_name")
        println("Authors name: $_author in $format format")
    }

    override fun readPage() {
        println("Books name: $_name")
        println("Authors name: $_author in $format format")
        this._words += 250
    }
}