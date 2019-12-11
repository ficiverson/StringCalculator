package testing.com.stringcalculator

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var state: State = State.LOGIN

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setText("Login")
        button.setOnClickListener { view ->
            if (State.LOGIN == state && username.text.toString() == "admin" && pass.text.toString() == "admin") {
                state = State.LOGOUT
                button.setText("Logout")
                username.visibility = View.GONE
                pass.visibility = View.GONE
                hideKeyboardFrom()
            } else if (State.LOGOUT == state && isTimeEven()) {
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun isTimeEven(): Boolean {
        return System.currentTimeMillis() % 2.0 == 0.0
    }

    private fun hideKeyboardFrom() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
    }
}

enum class State {
    LOGOUT, LOGIN
}
