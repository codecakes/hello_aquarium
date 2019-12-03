package ams.Books

import java.time.Year

fun main() {
    val myBook = Book("The Secret", "Rhonda Byrne")
    myBook.setBookYear(Year.of(2003))
    val (name, author, year) = myBook.moreInfo()
    println("Here is your book $name written by $author in $year.")
}