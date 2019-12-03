package ams.Books

open class Book(private var _name: String, private var _author: String) {
    private var _currentPage: Int = 1

    open fun readPage() {
        this._currentPage += 1
    }
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