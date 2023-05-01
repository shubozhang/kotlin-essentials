

package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*


/*
*
* 1. If you run the above code you'll see that it does not always print zero, though it may depend on the timings
of your machine you may need to tweak timeouts in this example to actually see non-zero values.
* */

private var acquired = 0

class Resource1 {
    init { acquired++ } // Acquire the resource
    fun close() { acquired-- } // Release the resource
}

fun main() {
    runBlocking {
        repeat(10_000) { // Launch 10K coroutines
            launch { 
                val resource = withTimeout(60) { // Timeout of 60 ms
                    delay(50) // Delay for 50 ms
                    Resource1() // Acquire a resource and return it from withTimeout block
                }
                resource.close() // Release the resource
            }
        }
    }
    // Outside runBlocking all coroutines have completed
    println(acquired) // Print the number of resources still acquired
}
