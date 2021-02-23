package ch01_datatype_null

/*
* 1. Kotlin default data types are int and double.
* 2. Kotlin does not automatically do data type conversion, like assign int to long. Conversion methods are available.
* 3. var means variable and it is mutable.
* 4. val means value (final) and it is immutable.
* */

fun main() {
    // default type: int and double
    val myInt = 1
    val pi = 3.14
    val e = 2.7182818284

    println("myInt is int: ${myInt is Int}")
    println("pi is double: ${pi is Double}")
    println("e is double: ${e is Double}")

    val oneByte: Byte = 1 // Byte type is required
    val oneShort: Short = 10  // Short type is required

    // Long
    val threeBillion = 3_000_000_000
    val oneLong = 1L

    // Float, actual value is 2.7182817
    val eFloat = 2.7182818284f
    val hexadecimals = 0x0F
    val binaries =  0b00001011

    testChar()

    testBoolean()

    boxing()
}

fun testChar() {
    // don't need declare type
    val oneChar = 'c'
    val myChar = 65.toChar()
    println(myChar)
}

fun testBoolean() {
    // don't need declare type
    val myBoolean = true
    println(myBoolean)
}

fun boxing() {
    val a = 10000
    println(a == a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // check reference. !!!Prints 'false'!!!
    println(boxedA == anotherBoxedA) // compare content. Prints 'true'
}
