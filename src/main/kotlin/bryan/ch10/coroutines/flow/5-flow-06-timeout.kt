package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple6(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)          
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) { // Timeout after 250ms 
        simple6().collect { value -> println(value) }
    }
    println("Done")
}
