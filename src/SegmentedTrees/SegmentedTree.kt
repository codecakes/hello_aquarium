package ams.SegmentedTrees

interface TreeMethods<T> {
    fun build(): MutableList<T>
    fun update(pos: Int, value: T)
    fun rangeQuery(lo: Int, hi: Int): T
}

abstract class Tree : TreeMethods<Int> {

    abstract override fun build(): MutableList<Int>

    abstract override fun update(pos: Int, value: Int)

    abstract override fun rangeQuery(lo: Int, hi: Int): Int
}

internal class SegmentedTree(
    private val arrayContainer: List<Int>,
    private val size: Int = arrayContainer.size,
    private val block: (Int, Int) -> Int,
    private val queryRangeCallBack: (Int, Int, Int) -> Triple<Int, Int, Int>
) : Tree() {

    private val auxTree: MutableList<Int> = mutableListOf()

    override fun build(): MutableList<Int> {
        // Generate a segmented tree array.
        val auxTreeSize = size.times(2).plus(1)
        (0..auxTreeSize).mapTo(auxTree) { 0 }.toMutableList()

        // Populate leaf nodes with original values.
        for (i in 0 until size) {
            auxTree[i + size] = arrayContainer[i]
        }
        // Populate internal nodes based on leaf values.
        for (i in size - 1 downTo 1) {
            auxTree[i] = i.shl(1).let { block(auxTree[it], auxTree[it xor 1]) }
        }
        return auxTree
    }

    override tailrec fun update(pos: Int, value: Int) {
        val newPos = pos.plus(size)
        auxTree[newPos] = value
        if (newPos.ushr(1) == 0) return
        else update(newPos.ushr(1), block(auxTree[newPos], auxTree[newPos xor 1]))
    }

    override fun rangeQuery(lo: Int, hi: Int): Int {
        return rangeQueryHelper(lo.plus(size), hi.plus(size))
    }

    private tailrec fun rangeQueryHelper(
        lo: Int,
        hi: Int,
        result: Int = 0
    ): Int {
        return if (lo >= hi) result
        else {
            val (newLo, newHi, newResult) = queryRangeCallBack.invoke(lo, hi, result)
            rangeQueryHelper(newLo, newHi, newResult)
        }
    }
}