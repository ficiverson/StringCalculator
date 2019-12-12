package testing.com.stringcalculator

import org.junit.Assert
import org.junit.Test

class MagicCounterCalculatorTest {


    @Test
    fun thatCanIncrementWithoutInitialValue() {
        val magicCounterCalculator = MagicCounterCalculator(givenAStorage(), givenARadomNumber(99))
        Assert.assertEquals(-1, magicCounterCalculator.decrement())

    }


    @Test
    fun thatCanIncrementByOneWithRandomGreaterThanOneHundred() {
        val magicCounterCalculator = MagicCounterCalculator(givenAStorage(37), givenARadomNumber(101))
        Assert.assertEquals(101, magicCounterCalculator.increment())

    }

    @Test
    fun thatCanIncrementByOneWithRandomLessThanOneHundred() {
        val magicCounterCalculator = MagicCounterCalculator(givenAStorage(37), givenARadomNumber(99))
        Assert.assertEquals(38, magicCounterCalculator.increment())

    }

    @Test
    fun thatCanDecrementWithoutInitialValue() {
        val magicCounterCalculator = MagicCounterCalculator(givenAStorage(), givenARadomNumber(99))
        Assert.assertEquals(-1, magicCounterCalculator.decrement())

    }


    @Test
    fun thatCanDecrementByOne() {
        val magicCounterCalculator = MagicCounterCalculator(givenAStorage(37), givenARadomNumber(99))
        Assert.assertEquals(36, magicCounterCalculator.decrement())

    }


    private fun givenAStorage(storagedValue: Int? = null) = object : StorageContra {
        override fun get(): Int? = storagedValue

        override fun clear() = Unit

        override fun save(value: Int) = Unit

    }


    private fun givenARadomNumber(number: Int) = object : RandomNumber {
        override fun generateMagicNumber(): Int = number
    }
}