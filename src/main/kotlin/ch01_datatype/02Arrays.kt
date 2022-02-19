package ch01_datatype

import java.math.BigDecimal

fun main() {
    val names = arrayOf("john", "doe")
    println(names is Array<String>)

    val long1 = arrayOf(1L, 2L, 3L)
    val long2 = arrayOf<Long>(1, 2, 3)
    val long3 = arrayOf(1, 2, 3)

    println(long1 is Array<Long>)
    println(long2 is Array<Long>)
    println(long3 is Array<Int>)


    primitiveTypeArray()

    loopArray()

    mixedTypeArray()
}


fun primitiveTypeArray() {
    // it is more efficient than general type of `arrayOf`. Also, it is matching to the Java primitive type of int type array
    val myIntArray = intArrayOf(1, 2, 3)
    val myIntArr2 = IntArray(5) // default value is 0
    val evenNum = Array(16) { i: Int -> i * 2 }
    for (num in evenNum) {
        println(num)
    }

    // using lambda
    val lotsOfNum = Array(10000000){ i: Int -> i }
    println(lotsOfNum.size)

    val allZeros = Array(100) {0}
    println(allZeros.size)
}

fun loopArray() {
    val someArray : Array<Int> = arrayOf(1, 2, 3)
    for (num in someArray) {
        println(num)
    }
}

fun mixedTypeArray() {
    val mixedArray = arrayOf("john", 12,  'A', BigDecimal("10.3"))
    for (e in mixedArray) {
        println(e)
    }
    println(mixedArray is Array<*>)
}
