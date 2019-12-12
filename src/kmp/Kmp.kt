package ams.kmp

internal interface Search {
    fun search(): MutableList<Int?>
}


class Kmp(private val txt: List<Char>, private val pat: List<Char>) : Search {
    private val txtLen: Int = txt.size
    private val n: Int = pat.size
    private val lps = (1..n).map { 0 }.toMutableList()
    private var lpsSet: Boolean = false
    private val result: MutableList<Int?> = mutableListOf()

    private var isLpsSet: Boolean
        get() = lps.any { it > 0 } || lpsSet
        set(value) {
            lpsSet = value
        }

    /**
     * Gets the Longest prefix suffix list.
     * @see ams.kmp.Kmp.populateLps
     */
    val getLps: List<Int>
        get() = lps

    private fun reAdjustLps(s: Char, index: Int, j: Int, j_modified: Boolean = false): Pair<Int, Int> {
        return when {
            (s == pat[j]) && !j_modified -> j.inc().let { Pair(it, it) }
            (s == pat[j]) && j_modified -> Pair(j, j.inc())
            j <= 0 -> Pair(j, 0)
            else -> reAdjustLps(s, index, lps[j.dec()], true)
        }
    }

    /**
     * Populates Longest prefix suffix list.
     * Sets isLpsSet to true once successfully complete.
     * @author @codecakes
     */
    val populateLps = {
        var j = 0
        if (n > 1) {
            pat.forEachIndexed { index, s ->
                if (index > 0) {
                    reAdjustLps(s, index, j).let {
                        j = it.first
                        lps[index] = it.second
                    }
                }
            }
        }
        isLpsSet = true
    }

    private fun kmpSearch(
        txtIdx: Int = 0,
        patIdx: Int = 0,
        result: List<Int> = listOf<Int>()
    ): List<Int> {
        return when {
            txtIdx == txtLen -> return result
            patIdx == this.n -> kmpSearch(txtIdx, lps[patIdx.dec()], result + listOf<Int>(txtIdx - patIdx))
            pat[patIdx] == txt[txtIdx] -> kmpSearch(txtIdx.inc(), patIdx.inc(), result)
            (pat[patIdx] != txt[txtIdx]) && (patIdx != 0) -> kmpSearch(txtIdx, lps[patIdx.dec()], result)
            else -> kmpSearch(txtIdx.inc(), patIdx, result)
        }
    }

    override fun search(): MutableList<Int?> {
        if (!isLpsSet) throw Exception("First initialize by running populateLps")
        return if (result.isEmpty()) {
            result.addAll(kmpSearch())
            result
        } else result
    }

}
