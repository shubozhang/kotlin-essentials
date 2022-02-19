package ch01_datatype

/*
* 1. Kotlin default data types are int and double.
* 2. Kotlin does not automatically do data type conversion, like assign int to long. Conversion methods are available.
* 3. var means variable and it is mutable.
* 4. val means value (final) and it is immutable.
* */

fun main() {

    testNums()

    testHex()

    testByte()

    testShort()

    testChar()

    testBoolean()

    boxing()
}

fun testNums(){
    // default type: int and double
    val myInt = 1
    val pi = 3.14
    val e = 2.7182818284

    println("myInt is int: ${myInt is Int}")
    println("pi is double: ${pi is Double}")
    println("e is double: ${e is Double}")

    // Float, actual value is 2.7182817
    val eFloat = 2.7182818284f
    println("my float is $eFloat")
}

fun testByte() {
    val oneByte: Byte = 1 // Byte type is required
    println("my byte is $oneByte")
}

fun testShort() {
    val oneShort: Short = 10  // Short type is required
    println("my short is $oneShort")
}

fun testLong() {
    val threeBillion = 3_000_000_000
    val oneLong = 1L

    println("my two longs are $threeBillion and $oneLong")
}

fun testHex(){

    val hexadecimals = 0x0F
    val binaries =  0b00001011

    println("my floats are $hexadecimals, and $binaries")
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
