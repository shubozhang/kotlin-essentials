

package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*

// Coroutines are light-weight
fun main() = runBlocking {
    repeat(50_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}
