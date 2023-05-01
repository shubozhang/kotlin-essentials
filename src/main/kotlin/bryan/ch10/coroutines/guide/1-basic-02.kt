

// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch { doWorld() }
    println("Hello")
}

// this is your first suspending function
private suspend fun doWorld() {
    delay(1000L)
    println("World!")
}
