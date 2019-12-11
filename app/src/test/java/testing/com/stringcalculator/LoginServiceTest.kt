package testing.com.stringcalculator

import org.junit.Assert
import org.junit.Test

class LoginServiceTest {

    var loginService = LoginService(object : TimeProvider {
        override fun getTime(): Long = if (evenTime) {
            validEvenTime
        } else {
            invalidEventTime
        }

    })
    val validCredentials = Pair("admin", "admin")
    val invalidCredentials = Pair("other", "other")
    val validEvenTime = 2L
    val invalidEventTime = 3L
    var evenTime = true


    @Test()
    fun thatCanLoginWithValidCredentials() {
        val result = loginService.logIn(validCredentials.first, validCredentials.second)
        Assert.assertTrue(result)
    }

    @Test()
    fun thatCannotLoginWithInvalidCredentials() {

        val result = loginService.logIn(invalidCredentials.first, invalidCredentials.second)
        Assert.assertFalse(result)
    }


    @Test()
    fun thatCanLogoutInEven() {
        evenTime = true
        val result = loginService.logOut()
        Assert.assertTrue(result)
    }

    @Test()
    fun thatCannotLogoutInEven() {
        evenTime = false
        val result = loginService.logOut()
        Assert.assertFalse(result)
    }
}