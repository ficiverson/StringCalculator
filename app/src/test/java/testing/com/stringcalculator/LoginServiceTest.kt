package testing.com.stringcalculator

import org.junit.Assert
import org.junit.Test

class LoginServiceTest {

    var loginService = LoginService()
    val validCredentials = Pair("admin", "admin")
    val invalidCredentials = Pair("other", "other")
    val validEvenTime = 2L
    val invalidEventTime = 3L


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
        val result = loginService.logOut(validEvenTime)
        Assert.assertTrue(result)
    }

    @Test()
    fun thatCannotLogoutInEven() {
        val result = loginService.logOut(invalidEventTime)
        Assert.assertFalse(result)
    }
}