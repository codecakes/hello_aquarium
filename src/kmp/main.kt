package ams.kmp

/**
 * main function. just testing for now :-)
 */
fun main() {
    val testlist: List<Char> = listOf('a', 'a', 'b', 'a', 'a', 'b', 'a', 'a', 'a')
    val pattern = listOf<Char>('a', 'a', 'b')
    val lps = Kmp(testlist, pattern)
    lps.populateLps()
    println(lps.getLps)
    println(lps.search())
    val test2 = listOf<Char>('a', 'b', 'c', 'd', 'a', 'b', 'c', 'a')
    val pattern2 = listOf<Char>('b', 'c', 'd')
    val lps2 = Kmp(test2, pattern2)
    lps2.populateLps()
    println(lps2.getLps)
    println(lps2.search())
}