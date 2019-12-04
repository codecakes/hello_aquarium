package ams.kmp

fun main() {
    val testlist: List<Char> = listOf('a', 'a', 'b', 'a', 'a', 'b', 'a', 'a', 'a')
//    val test2 = listOf<Char>('a', 'b', 'c', 'd', 'a', 'b', 'c', 'a')
    val pattern = listOf<Char>('a', 'a', 'b')
    val lps = Kmp(testlist, pattern)
    lps.populateLps()
    println(lps.getLps)
    println(lps.search())
//    val lps2 = Kmp(test2)
//    lps2.populateLps()
//    println(lps2.lps)
}