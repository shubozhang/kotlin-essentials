package ch01_datatype_null

/*
* 1. Kotlin default data types are int and double.
* 2. Kotlin does not automatically do data type conversion, like assign int to long. Conversion methods are available.
* 3. var means variable and it is mutable.
* 4. val means value (final) and it is immutable.
* */

fun main() {
    val oneByte: Byte = 1 // Byte type is required
    val oneShort: Short = 10  // Short type is required
    val one = 1 // default type is int
    val threeBillion = 3_000_000_000 // Long
    val oneLong = 1L // Long

    val pi = 3.14 // default Double
    val e = 2.7182818284 // default Double
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817

    val hexadecimals = 0x0F
    val binaries =  0b00001011

    val myChar = 65.toChar()
    println(myChar)


    val myBoolean = true

    boxing()
}


fun boxing() {
    val a = 10000
    println(a == a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // check reference. !!!Prints 'false'!!!
    println(boxedA == anotherBoxedA) // compare content. Prints 'true'
}