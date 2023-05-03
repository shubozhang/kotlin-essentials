package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
                      
fun simple14(): Flow<Int> = flow {
    // The WRONG way to change context for CPU-consuming code in flow builder
    kotlinx.coroutines.withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100) // pretend we are computing it in CPU-consuming way
            emit(i) // emit next value
        }
    }
}

fun simple15(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it in CPU-consuming way
        log("Emitting $i")
        emit(i) // emit next value
    }
}.flowOn(Dispatchers.Default) // RIGHT way to change context for CPU-consuming code in flow builder


fun wrongFlowOn() = runBlocking<Unit> {
    simple14().collect { value -> println(value) }
}



fun correctFlowOn() = runBlocking<Unit> {
    simple15().collect { value -> log("Collected $value") }
}

fun main() {
    wrongFlowOn()

    correctFlowOn()
}