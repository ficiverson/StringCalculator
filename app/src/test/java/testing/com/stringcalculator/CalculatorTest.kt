package testing.com.stringcalculator

import org.junit.Assert
import org.junit.Test

class CalculatorTest{
    @Test
    fun thatCanAddInputAnEmptyValue() {
        val result = Calculator().add("")
        Assert.assertEquals(0, result)
    }

    @Test
    fun thatCanAddInputAInvalidInput() {
        val result = Calculator().add("Paquito")
        Assert.assertEquals(0, result)
    }

    @Test
    fun thatCanAddInputANumber() {
        val result = Calculator().add("1")
        Assert.assertEquals(1, result)
    }

    @Test
    fun thatCanAddInputASecuenceOfNumbers() {
        val result = Calculator().add("1,1")
        Assert.assertEquals(2, result)
    }

    @Test
    fun thatCanAddInputASecuenceOfNumbersAndInvalidINputs() {
        val result = Calculator().add("1,1,Buf")
        Assert.assertEquals(2, result)
    }
}
