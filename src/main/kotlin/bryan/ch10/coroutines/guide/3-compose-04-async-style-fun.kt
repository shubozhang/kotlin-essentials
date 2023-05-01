

package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*
import kotlin.system.*

// THIS STYLE IS STRONGLY DISCOURAGED.
// This programming style with async functions is provided here only for illustration, because it is a popular style in
// other programming languages.

// note that we don't have `runBlocking` to the right of `main` in this example

/*
* Consider what happens if between the val one = somethingUsefulOneAsync() line and one.await() expression there is some
* logic error in the code and the program throws an exception and the operation that was being performed by the program aborts.
* Normally, a global error-handler could catch this exception, log and report the error for developers, but the program
* could otherwise continue doing other operations. But here we have somethingUsefulOneAsync still running in the background,
* even though the operation that initiated it was aborted.
* */
fun main() {
    val time = measureTimeMillis {
        // we can initiate async actions outside a coroutine
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        // but waiting for a result must involve either suspending or blocking.
        // here we use `runBlocking { ... }` to block the main thread while waiting for the result
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne4()
}

@OptIn(DelicateCoroutinesApi::class)
fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo4()
}

suspend fun doSomethingUsefulOne4(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo4(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}
