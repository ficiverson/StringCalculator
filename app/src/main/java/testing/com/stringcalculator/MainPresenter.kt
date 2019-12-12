package testing.com.stringcalculator

class MainPresenter(
    private var state: State,
    private val view: MainView,
    private val loginService: LoginService
) {

    fun onLoginButtonClick(userName: String, password: String) {
        if (State.LOGIN == state && loginService.logIn(userName, password)) {
            state = State.LOGOUT
            view.showLogoutForm()
        } else if (State.LOGOUT == state && loginService.logOut()) {
            state = State.LOGIN
            view.showLoginState()
        } else {
            view.showError()
        }
    }
}

interface MainView {
    fun showLoginState()
    fun showLogoutForm()
    fun showError()
}

enum class State {
    LOGOUT, LOGIN
}