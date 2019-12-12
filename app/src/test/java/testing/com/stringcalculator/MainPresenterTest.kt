package testing.com.stringcalculator

import org.junit.After
import org.junit.Assert
import org.junit.Test

class MainPresenterTest {
    var interactionResult : InteractionResult = InteractionResult.NONE
    var mainView = object : MainView{
        override fun showLogoutForm() {
            interactionResult = InteractionResult.SHOW_LOGOUT
        }

        override fun showError() {
            interactionResult = InteractionResult.SHOW_ERROR
        }

        override fun showLoginState() {
            interactionResult = InteractionResult.SHOW_LOGIN
        }

    }

    @After
    fun after(){
        interactionResult = InteractionResult.NONE
    }

    @Test()
    fun thatCaLoginWithValidCredentials() {
        val presenter = MainPresenter(view = mainView, state = State.LOGIN, loginService = LoginService(TimeProviderInstrument().givenATimeProvider()))
        presenter.onLoginButtonClick("admin","admin")
        Assert.assertTrue(interactionResult == InteractionResult.SHOW_LOGOUT)
    }

    @Test()
    fun thatCantLoginWithInValidCredentials() {
        val presenter = MainPresenter(view = mainView, state = State.LOGIN, loginService = LoginService(TimeProviderInstrument().givenATimeProvider()))
        presenter.onLoginButtonClick("admin2","admin2")
        Assert.assertTrue(interactionResult == InteractionResult.SHOW_ERROR)
    }

    @Test()
    fun thatCanLogout() {
        val presenter = MainPresenter(view = mainView, state = State.LOGOUT, loginService = LoginService(TimeProviderInstrument().givenATimeProvider()))
        presenter.onLoginButtonClick("admin2","admin2")
        Assert.assertTrue(interactionResult == InteractionResult.SHOW_LOGIN)
    }

    @Test()
    fun thatCantLogoutInOdd() {
        val presenter = MainPresenter(view = mainView, state = State.LOGOUT, loginService = LoginService(TimeProviderInstrument().givenATimeProvider(isEven = false)))
        presenter.onLoginButtonClick("admin2","admin2")
        Assert.assertTrue(interactionResult == InteractionResult.SHOW_ERROR)
    }


}

enum class InteractionResult {
    SHOW_LOGOUT, SHOW_LOGIN, SHOW_ERROR, NONE
}