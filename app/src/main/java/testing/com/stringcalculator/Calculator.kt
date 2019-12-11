package testing.com.stringcalculator

class Calculator {

    fun add(input: String): Int = input.split(",", "/n").mapNotNull { it.trim().toIntOrNull().negativeValue() }.sum()
}


fun Int?.negativeValue(): Int? {
    return this?.let {
        if (it >= 0) {
            this
        } else {
            throw NegativeException(this.toString())
        }
    }
}

class NegativeException(inputValue: String) : Exception()

class WrongDelimiterException : Exception()