package ams.SegmentedTrees

/**
 *
 */
interface TreeMethods<T> {
    fun build(): MutableList<T>
    fun update(pos: Int, value: T)
    fun rangeQuery(lo: Int, hi: Int): T
}

/**
 *
 */
abstract class Tree : TreeMethods<Int> {

    abstract override fun build(): MutableList<Int>

    abstract override fun update(pos: Int, value: Int)

    abstract override fun rangeQuery(lo: Int, hi: Int): Int
}

internal class SegmentedTree(
    private val arrayContainer: List<Int>,
    private val size: Int = arrayContainer.size,
    private val block: (Int, Int) -> Int
) : Tree() {

    private val auxTree: MutableList<Int> = mutableListOf()

    private val setVal: (index: Int, value: Int) -> Unit = { index, value ->
        auxTree[index] = value
    }

    val getTree
        get() = auxTree

    override fun build(): MutableList<Int> {
        // Generate a segmented tree array.
        val auxTreeSize = size.times(2).plus(1)
        (0..auxTreeSize).mapTo(auxTree) { 0 }.toMutableList()

        // Populate leaf nodes with original values.
        (0 until size).forEach {
            setVal(it + size, arrayContainer[it])
        }

        // Populate internal nodes based on leaf values.
        (size - 1 downTo 1).forEach {
            setVal(it, it.shl(1).let { idx -> block(auxTree[idx], auxTree[idx xor 1]) })
        }
        return auxTree
    }

    override fun update(pos: Int, value: Int) {
        updateHelper(pos.plus(size), value)
    }

    private tailrec fun updateHelper(pos: Int, value: Int) {
        setVal(pos, value)
//        println("still running")
        if (pos.ushr(1) == 0) return
        else updateHelper(pos.ushr(1), block(auxTree[pos], auxTree[pos xor 1]))
    }

    @Throws
    override fun rangeQuery(lo: Int, hi: Int): Int {
        if (lo < 0 || hi >= size) {
            throw Exception("Out Of Bound IndexError")
        } else return rangeQueryHelper(lo.plus(size), hi.plus(size))
    }

    private tailrec fun rangeQueryHelper(
        lo: Int,
        hi: Int,
        result: Int = 0
    ): Int {
        return if (lo >= hi) result
        else {
            val (newResultLo, newLo) = if ((lo and 1) == 1) {
                Pair(block(result, auxTree[lo]), lo.inc())
            } else Pair(result, lo)
            val (newResultHi, newHi) = if ((hi and 1) == 1) {
                Pair(block(newResultLo, auxTree[hi.dec()]), hi.dec())
            } else Pair(newResultLo, hi)
            rangeQueryHelper(newLo.ushr(1), newHi.ushr(1), newResultHi)
        }
    }
}