package testing.com.stringcalculator

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginServiceTest {
    val validCredentials = Pair("admin", "admin")
    val invalidCredentials = Pair("other", "other")


    @Test()
    fun thatCanLoginWithValidCredentials() {
        val loginService  = LoginService(TimeProviderInstrument().givenATimeProvider())
        val result = loginService.logIn(validCredentials.first, validCredentials.second)
        Assert.assertTrue(result)
    }

    @Test()
    fun thatCannotLoginWithInvalidCredentials() {
        val loginService  = LoginService(TimeProviderInstrument().givenATimeProvider())
        val result = loginService.logIn(invalidCredentials.first, invalidCredentials.second)
        Assert.assertFalse(result)
    }


    @Test()
    fun thatCanLogoutInEven() {
        val loginService  = LoginService(TimeProviderInstrument().givenATimeProvider())
        val result = loginService.logOut()
        Assert.assertTrue(result)
    }

    @Test()
    fun thatCannotLogoutInOdd() {
        val loginService  = LoginService(TimeProviderInstrument().givenATimeProvider(isEven = false))
        val result = loginService.logOut()
        Assert.assertFalse(result)
    }
}

class TimeProviderInstrument {
    fun givenATimeProvider(isEven: Boolean = true) = object : TimeProvider {
        override fun getTime(): Long = if (isEven) {
            2L
        } else {
            3L
        }

    }
}