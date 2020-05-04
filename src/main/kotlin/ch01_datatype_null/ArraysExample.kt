package ch01_datatype_null

import java.math.BigDecimal

fun main() {
    val names = arrayOf("john", "doe")

    val long1 = arrayOf(1L, 2L, 3L)
    val long2 = arrayOf<Long>(1, 2, 3)
    val long3 = arrayOf(1, 2, 3)

    println(long1 is Array<Long>)
    println(long3 is Array<Int>)

    val evenNum = Array(16) { i: Int -> i * 2 }
    for (num in evenNum) {
        println(num)
    }

    var lotsOfNum = Array(10000000){i: Int -> i }
    var allZeros = Array(100) {0}

    var someArray : Array<Int>
    someArray = arrayOf(1, 2, 3)
    for (num in someArray) {
        println(num)
    }


    val mixedArray = arrayOf("john", 12,  'A', BigDecimal("10.3"))
    for (e in mixedArray) {
        println(e)
    }
    println(mixedArray is Array<*>)

    // it is more efficient than general type of `arrayOf`. Also, it is matching to the Java primitive type of int type array
    val myIntArray = intArrayOf(1, 2, 3)
    val myIntArr2 = IntArray(5) // default value is 0
}