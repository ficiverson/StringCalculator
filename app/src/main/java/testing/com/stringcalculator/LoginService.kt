package testing.com.stringcalculator

class LoginService(
    private val timeProvider: TimeProvider
) {

    fun logIn(user: String, pass: String): Boolean = user == "admin" && pass == "admin"

    fun logOut() = timeProvider.getTime() % 2L == 0L
}

interface TimeProvider {
    fun getTime(): Long
}