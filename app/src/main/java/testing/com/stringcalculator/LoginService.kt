package testing.com.stringcalculator

class LoginService {

    fun logIn(user: String, pass: String): Boolean = user == "admin" && pass == "admin"

    fun logOut(time : Long) = time % 2L == 0L
}