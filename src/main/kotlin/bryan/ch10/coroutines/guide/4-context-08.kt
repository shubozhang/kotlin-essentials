package bryan.ch10.coroutines.guide

import kotlinx.coroutines.*

fun log8(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking(CoroutineName("main")) {
    log8("Started main coroutine")
    // run two background value computations
    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log8("Computing v1")
        252
    }
    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log8("Computing v2")
        6
    }
    log8("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}
