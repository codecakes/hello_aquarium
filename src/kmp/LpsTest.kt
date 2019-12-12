package ams.kmp

//
//import groovy.lang.GroovyLogTestCase
//import groovy.transform.ASTTest
//import io.kotlintest.specs.StringSpec
//import io.kotlintest.specs.FunSpec
//import io.kotlintest.TestCase
//import io.kotlintest.TestResult
//import io.kotlintest.shouldBe
//import io.kotlintest.matchers.exactly
//import io.kotlintest.matchers.shouldBe
//import io.kotlintest.specs.FunSpec
//
//class LpsTest : FunSpec() {
//
////    override fun beforeTest(testCase: TestCase) {
////    }
////
////    override fun afterTest(testCase: TestCase, result: TestResult) {
////    }
//
//    init {
//        testEqualPopulatePrefixIdx()
//    }
//
//    private val testlist: List<Char> = listOf('a', 'a', 'b', 'a', 'a', 'b', 'a', 'a', 'a')
//    private val lpsResult: List<Int> = listOf(0,1,0,1,2,3,4,5,2)
//
//    fun testEqualPopulatePrefixIdx(test: LpsTest) {
//        val lps = Lps(testlist)
//        lps.lps shouldBe exactly(lpsResult)
//    }
//
//
//}