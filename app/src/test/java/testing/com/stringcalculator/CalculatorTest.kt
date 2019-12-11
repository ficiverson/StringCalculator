package testing.com.stringcalculator

import org.junit.Assert
import org.junit.Test

class CalculatorTest {

    private val scenarios = listOf(
        Pair("", 0),
        Pair("Paquito", 0),
        Pair("1", 1),
        Pair("1,1", 2),
        Pair("11,22,33", 66), Pair("11,-22,33", 22),
        Pair("1,1,Buf", 2),
        Pair("1 , 1", 2),
        Pair("1,1/n2", 4)
    )

    @Test(expected = NegativeException::class)
    fun thatCanAddInputAnyValue() {
        scenarios.forEach {
            val result = Calculator().add(it.first)
            Assert.assertEquals(it.second, result)
        }
    }
}
