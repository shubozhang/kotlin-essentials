package bryan.ch10.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


/*
* Asynchronous Flow
A suspending function asynchronously returns a single value, but how can we return multiple asynchronously computed values?
* */

// represent numbers using collections
fun simple1(): List<Int> = listOf(1, 2, 3)

// represent numbers using sequence
fun simple2(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it
        yield(i) // yield next value
    }
}

// represent numbers using collections without blocking
suspend fun simple3(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun runSimple3() = runBlocking<Unit> {
    simple3().forEach { value -> println(value) }
}
fun main() {
    simple1().forEach { value -> println(value) }

    simple2().forEach { value -> println(value) }

    runSimple3()
}


