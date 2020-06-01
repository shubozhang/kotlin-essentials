package ch_loops

import java.math.BigDecimal

// In `when` expression, `else` must be included, like `if` expression.

fun main() {
    getWhen(201)
    getWhen2(100)
    getWhen3(BigDecimal(21))

    getWhen5(Season.WINTER)

    getWhen6(1, 5)
    getWhen6(6, 2)
    getWhen6(6, 6)
}

fun getWhen(num: Int) {
    when(num) {
        100, 600 -> println("600")
        in 200..299 -> println("in range 200 to 299")
        300 -> println("300")
        else -> println("Does not match anything")
    }
}

fun getWhen2(num: Int) {
    val x = 10
    when(num) {
        x + 80 -> println("90")
        x + 90 -> println("100")
        300 -> println("300")
        else -> println("Does not match anything")
    }
}

fun getWhen3(something: Any) {
    when(something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something - 22}")
    }
}


// In `when` expression, `else` must be included.
fun getWhen4(something: Any): Any {
    val res = when(something) {
        is String -> something.toUpperCase()
        is BigDecimal -> something.remainder(BigDecimal(10.5))
        is Int -> something - 22
        else -> false
    }
    return res
}

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}

// when expression does not need to include `else` for enum, but enum has to cover all possible values.
fun getWhen5(seasonOfYear: Season) {
    var res = when(seasonOfYear){
        Season.SPRING -> "flowers are blooming"
        Season.SUMMER  -> "playing water"
        Season.FALL -> "red leaves"
        Season.WINTER -> "skiing"
    }
    println(res)

}

fun getWhen6(num1: Int, num2: Int) {
    when {
        num1 > num2 -> println("$num1 is less than $num2")
        num1 < num2 -> println("$num1 is greater than $num2")
        else -> println("$num1 is equal to $num2")
    }
}