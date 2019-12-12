package testing.com.stringcalculator

class MagicCounterCalculator(private val storage: StorageContra, private val randomNumber: RandomNumber) {
    fun increment(): Int {
        return storage.get()?.let {
            var randomNumber = randomNumber.generateMagicNumber()
            if (randomNumber > 100) {
                storage.save(randomNumber)
            } else {
                randomNumber = it + 1
            }
            storage.save(randomNumber)
            randomNumber
        } ?: 0
    }

    fun decrement(): Int {
        return storage.get()?.let {
            val decrementValue = it - 1
            storage.save(decrementValue)
            decrementValue
        } ?: -1
    }
}

interface RandomNumber {
    fun generateMagicNumber(): Int
}