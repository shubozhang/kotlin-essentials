

package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*

// Scope builder
fun main() = runBlocking {
    doWorld()
}

private suspend fun doWorld() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}
