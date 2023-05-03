package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple31(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    try {
        simple31().collect { value -> println(value) }
    } finally {
        println("Done")
    }
}            
