package testing.com.stringcalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(view = this, state = State.LOGIN ,loginService = LoginService(object : TimeProvider {
        override fun getTime(): Long = System.currentTimeMillis()
    }))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setText("Login")
        button.setOnClickListener { view ->
            presenter.onLoginButtonClick(username.text.toString(), pass.text.toString())
        }
    }

    override fun showLoginState() {
        button.setText("Login")
        username.visibility = View.VISIBLE
        pass.visibility = View.VISIBLE
    }

    override fun showLogoutForm() {
        button.setText("Logout")
        username.visibility = View.GONE
        pass.visibility = View.GONE
    }

    override fun showError() {
        Snackbar.make(findViewById(android.R.id.content), "Invalid credentials", Snackbar.LENGTH_LONG)
            .setAction("Close", null).show()
    }
}


