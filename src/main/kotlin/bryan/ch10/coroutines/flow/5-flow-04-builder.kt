package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


/*
* Notice the following differences in the code with the Flow from the earlier examples:
— A builder function for Flow type is called 􏰁ow.
— Code inside the flow { ... } builder block can suspend.
— The simple function is no longer marked with suspend modifier. — Values are emitted from the 􏰁ow using emit function.
— Values are collected from the 􏰁ow using collect function.
* */
fun simple4(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow
    simple4().collect { value -> println(value) }
}
