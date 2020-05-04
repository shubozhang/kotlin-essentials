package ch01_datatype_null

/*
* 1. Best practices that do not define nullable type unless you have to.
* 2.
* */

fun main() {
    // example 1: nullable obj
    val str: String? = "this is not a null"
    val str1: String? = null
    println("what happens when we do this: ${str?.toUpperCase()}")
    println("what happens when we do this: ${str1?.toUpperCase()}")


    // example 2: String and String? are two different type: printText(str) type mismatch error
    // first way
    printText(str!!)

    // second way: let function
    str?.let { printText(str) }

    // second way is equivalent to
    if (str != null) {
        printText(str)
    }

    // example 3: `==` is a safe operator
    val vNull: String? = null
    val vCon = "I am non-null string"
    println(vNull == vCon)


    // example 4: non-null assertion `!!`, if you want to throw nullPointerException
    val v1: String? = null
    val v2 = v1!!               // exception throws at this line.
    val v3 = v2.toUpperCase()

}

fun printText(text: String) {
    println(text)
}