package ams.CountInversion

fun merge(q: MutableList<Int>, lo_1: Int, hi_1: Int, lo_2: Int, hi_2: Int): Int {
    val aux = (lo_1..hi_2).map { 0 }.toMutableList()
    var count: Int = 0
    var i = lo_1
    var j = lo_2
    var countInversions = 0
//    println("aux $aux")
    for (it in lo_1..hi_2) {
        if (i > hi_1 || j > hi_2) break
        else if (q[i] > q[j]) {
//            println("index i $i j $j comparing ${q[i]} ${q[j]}")
            aux[count] = q[j]
            ++j
            countInversions += hi_1 - i + 1
        } else {
//            println("index i $i j $j comparing ${q[i]} ${q[j]}")
            aux[count] = q[i]
            ++i
        }
        ++count
    }
//    println("inversion count $countInversions")
    (i..hi_1).forEach {
        aux[count] = q[it]
        ++count
    }
    (j..hi_2).forEach {
        aux[count] = q[it]
        ++count
    }
    aux.forEachIndexed { index, num ->
        q[index + lo_1] = num
    }
    return countInversions
}

fun countInversion(q: MutableList<Int>, lo: Int, hi: Int): Int {
    val mid = lo + (hi - lo).div(2)
    return if (lo >= hi) 0
    else {
        listOf(Pair(lo, mid), Pair(mid + 1, hi)).map {
            countInversion(q, it.first, it.second)
        }.sum() + merge(q, lo, mid, mid + 1, hi)
    }
}

fun main() {
    println(countInversion(mutableListOf(1, 2, 5, 3, 4, 7, 8, 6), 0, 7))
    println(countInversion(mutableListOf(1, 2, 5, 3, 7, 8, 6, 4), 0, 7))
    println(countInversion(mutableListOf(2, 1, 5, 3, 4), 0, 4))
}