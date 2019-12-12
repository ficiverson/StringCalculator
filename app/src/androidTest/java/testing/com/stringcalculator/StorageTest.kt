package testing.com.stringcalculator

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StorageTest {
    lateinit var storage : Storage

    @Before
    fun before(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        storage = Storage(appContext)
        storage.clear()
    }

    @After
    fun after(){
        storage.clear()
    }

    @Test
    fun thatCangetNullValueWhenIsEmpty() {
        assertEquals(null, storage.get())
    }

    @Test
    fun thatCanStorageAValue() {
        storage.save(3)
        assertEquals(3, storage.get())
    }

    @Test
    fun thatCanStorageAValueAndOverride() {
        storage.save(3)
        storage.save(23)
        assertEquals(23, storage.get())
    }

    @Test
    fun thatCanClearStorage() {
        storage.save(3)
        storage.clear()
        assertEquals(null, storage.get())
    }
}