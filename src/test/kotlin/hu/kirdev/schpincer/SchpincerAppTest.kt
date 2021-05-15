package hu.kirdev.schpincer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalStateException

class SchpincerAppTest {

    @Test
    fun test() {
        assertTrue(true)
    }

}

inline fun <reified T : Throwable> getException(runnable: Runnable) : T {
    try {
        runnable.run()
        throw IllegalStateException("No exception was thrown but expected: ${T::class.simpleName}")
    } catch(e: Throwable) {
        return if (e is T) e else throw IllegalStateException("Unexpected exception type: ${e.javaClass.simpleName} expected: ${T::class.simpleName}", e)
    }
}