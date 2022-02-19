package ch02_control_flow

import java.lang.Integer.parseInt

/*
1. Replace switch statement
2. Can be used either as an expression or as a statement
*/

fun main(){

    test01()

    test02()

    test03()

    test04()

    testReplacement()

}

fun test01(){
    val x = 0
    when (x) {
        0, 1 -> println("x == 0 or x == 1") else -> println("otherwise")
    }

}

fun test02(){
    val x = 100
    val s = "100"
    when (x) {
        parseInt(s) -> println("s encodes x") else -> println("s does not encode x")
    }
}


fun test03(){
    when (9) {
        in 1..10 -> println("x is in the range")
        in 3..9 -> println("x is valid")
        !in 10..20 -> println("x is outside the range") else -> println("none of the above")
    }
}

fun test04(){
    println(hasPrefix("prefix-x"))
    println(hasPrefix("x"))
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix") else -> false
}


fun testReplacement(){
    val x: Int = 5
    val y : Int = 6
    when {
        isOddNum(x) -> print("x is odd")
        isOddNum(y) -> print("y is even")
        else -> print("x+y is odd.")
    }
}


private fun isOddNum(num: Int): Boolean {
    return (num.and(1) != 0)
}


/*Since Kotlin 1.3, it is possible to capture when subject in a variable using following syntax:
fun Request.getBody() =
    when (val response = executeRequest()) {
        is Success -> response.body
        is HttpError -> throw HttpException(response.status) }*/
