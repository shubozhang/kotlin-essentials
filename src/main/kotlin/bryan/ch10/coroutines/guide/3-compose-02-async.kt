

package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*
import kotlin.system.*

/*
* Conceptually, async is just like launch. It starts a separate coroutine which is a light-weight thread
* that works concurrently with all the other coroutines. The difference is that launch returns a Job and
* does not carry any resulting value, while async returns a Deferred — a light-weight non-blocking future
* that represents a promise to provide a result later.
* */
fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne2() }
        val two = async { doSomethingUsefulTwo2() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne2(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo2(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}
