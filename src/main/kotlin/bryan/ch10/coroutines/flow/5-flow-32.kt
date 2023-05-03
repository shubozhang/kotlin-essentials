package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple32(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    simple32()
        .onCompletion { println("Done") }
        .collect { value -> println(value) }
}            
