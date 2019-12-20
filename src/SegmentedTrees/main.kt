package ams.SegmentedTrees

fun main() {
//    val a = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
//    val s = SegmentedTree(a) { x, y -> if (x.compareTo(y) == 1) x else y }
//    println(s.build())
//    println(s.rangeQuery(0, 12))
//    s.update(0, 100)
//    println(s.getTree)
//    println(s.rangeQuery(0, 12))
//    s.update(11, 500)
//    println(s.getTree)
//    println(s.rangeQuery(0, 12))
    val a = listOf(-1, 0, 3, 6)
    val s = SegmentedTree(a) { x, y -> if (x.compareTo(y) < 1) x else y }
    println(s.build())
    println(s.rangeQuery(-1, 120))
}