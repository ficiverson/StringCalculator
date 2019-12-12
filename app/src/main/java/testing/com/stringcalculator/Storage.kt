package testing.com.stringcalculator

import android.content.Context


class Storage(private val context: Context) : StorageContra {

    companion object {
        const val PREF_NAME = "KATATA"
        const val MAIGC_NUMBER = "magic_numbber"
    }

    override fun save(value: Int) {
        val editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        editor.putString(MAIGC_NUMBER, value.toString())
        editor.apply()

    }

    override fun get(): Int? = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(MAIGC_NUMBER, null)?.toIntOrNull()

    override fun clear() {
        val editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        editor.clear().apply()
    }
}

interface StorageContra {
    fun save(value: Int)

    fun get(): Int?

    fun clear()
}