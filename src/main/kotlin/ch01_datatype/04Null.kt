package ch01_datatype

/*
* 1. Best practices that do not define nullable type unless you have to.
* */

fun main() {
    testNullableObj()

    testEqual()

    testNullableArray()

    testNonNullAssertion()
}

fun testNullableObj() {
    val str: String? = "this is not a null"
    val str1: String? = null
    println("what happens when we do this: ${str?.toUpperCase()}")
    println("what happens when we do this: ${str1?.toUpperCase()}")


    // String and String? are two different type: printText(str) type mismatch error
    // first way
    printText(str!!)

    // second way: let function
    str?.let { printText(str) }

    // second way is equivalent to
    if (str != null) {
        printText(str)
    }
}

fun testEqual() {
    // example 3: `==` is a safe operator
    val vNull: String? = null
    val vCon = "I am non-null string"
    println(vNull == vCon)
}


fun testNullableArray(){

    // example 4: nullable array
    val nullableInts = arrayOfNulls<Int>(5)
    for (i in nullableInts) {
        println(i.toString())
    }
}

fun testNonNullAssertion(){
    // non-null assertion `!!`, if you want to throw nullPointerException
    val v1: String? = null
    val v2 = v1!!               // exception throws at this line.
    val v3 = v2.toUpperCase()

    println("Testing non-null assertion $v3")
}

fun printText(text: String) {
    println(text)
}
