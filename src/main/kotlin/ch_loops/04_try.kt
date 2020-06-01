package ch_loops

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

// 1. In Kotlin, try/catch can be used as expression
// 2. final block does not return value



fun main() {
    println(getNumber("22"))
    println(getNumber("22.5"))
    println(getNumber2("22.5")?: throw IllegalArgumentException("Number is not a valid input"))
}


fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        println("NumberFormatException")
        0
    } finally {
        println("finally block")
        1
    }
}

fun getNumber2(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        println("NumberFormatException")
        null
    } finally {
        println("finally block")
    }
}

fun toDoFun(something: String): Nothing {
    throw IllegalArgumentException("implementing me")
}