package testing.com.stringcalculator

class Calculator {
    fun add(input: String): Int {
        return input.split(",").mapNotNull { it.toIntOrNull() }.sum()
    }
}