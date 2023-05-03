

// This file was automatically generated from flow.md by Knit tool. Do not edit.
package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple28(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i) // emit next value
        }
    }
    .map { value ->
        check(value <= 1) { "Crashed on $value" }                 
        "string $value"
    }

fun main() = runBlocking<Unit> {
    simple28()
        .catch { e -> emit("Caught $e") } // emit on exception
        .collect { value -> println(value) }
}            
