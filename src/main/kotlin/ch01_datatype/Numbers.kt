package ch01_datatype

fun main() {
    val oneByte: Byte = 1
    val oneShort: Short = 10
    val one = 1 // int
    val threeBillion = 3_000_000_000 // Long
    val oneLong = 1L // Long

    val pi = 3.14 // Double
    val e = 2.7182818284 // Double
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817

    val hexadecimals = 0x0F
    val binaries =  0b00001011
}

fun boxing() {
    val a: Int = 10000
    println(a == a) // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
    println(boxedA == anotherBoxedA) // Prints 'true'
}