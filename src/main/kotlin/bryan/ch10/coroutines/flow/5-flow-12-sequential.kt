package bryan.ch10.coroutines.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/*
* Flows are sequential
* Each individual collection of a 􏰁ow is performed sequentially unless special operators that operate on multiple flows are used.
* The collection works directly in the coroutine that calls a terminal operator. No new coroutines are launched by default.
* Each emitted value is processed by all the intermediate operators from upstream to downstream and is then delivered to
* the terminal operator after.
* */
fun main() = runBlocking<Unit> {
    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it % 2 == 0
        }
        .map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }
}
