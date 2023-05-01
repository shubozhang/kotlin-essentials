

package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*

fun log1(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log1("Started in ctx1")
                withContext(ctx2) {
                    log1("Working in ctx2")
                }
                log1("Back to ctx1")
            }
        }
    }
}
