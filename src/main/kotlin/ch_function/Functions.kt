package ch_function

fun hello(): Unit{
    println("hello")
}

fun testNothing(): Nothing {
    throw Exception("this func throws exception")
}

fun sum(x: Int, y: Int, z: Int = 0) =  x + y + z

fun printDetails(name: String, email: String = "", phone: String) {
    println("name: $name  email: $email, phone: $phone")
}

fun printStrings (vararg strings: String) {
    strings.forEach { e -> println(e) }
}

fun printStr (vararg strings: String) {
    printJob(*strings)
}

fun printJob(vararg strings: String) {
    strings.forEach { e -> println(e) }
}

fun main() {
    hello()

    //testNothing()

    sum(1, 2)

    printDetails("zhang", phone = "443")
    printDetails("zhang", phone = "443", email = "zhang@gmail.com")

    printStrings("a", "b", "c")
    printStr("a", "b", "c")
}