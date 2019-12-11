package testing.com.stringcalculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var state: State = State.LOGIN
    val loginService = LoginService(object : TimeProvider {
        override fun getTime(): Long = System.currentTimeMillis()
    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setText("Login")
        button.setOnClickListener { view ->
            if (State.LOGIN == state && loginService.logIn(username.text.toString(), pass.text.toString())) {
                state = State.LOGOUT
                button.setText("Logout")
                username.visibility = View.GONE
                pass.visibility = View.GONE
            } else if (State.LOGOUT == state && loginService.logOut()) {
                state = State.LOGIN
                button.setText("Login")
                username.visibility = View.VISIBLE
                pass.visibility = View.VISIBLE
            } else {
                Snackbar.make(view, "Invalid credentials", Snackbar.LENGTH_LONG)
                    .setAction("Close", null).show()
            }
        }
    }
}

enum class State {
    LOGOUT, LOGIN
}
