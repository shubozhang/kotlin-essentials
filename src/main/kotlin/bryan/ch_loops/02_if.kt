package bryan.ch_loops

// In Kotlin, if can be used as an expression.
// 1. In `if` expression, `else` must be included:
//      wrong: val str = if (condition) "A"
//      correct: val str = if(condition) "A" else "B"

fun main() {
    println(setAge(0))
    println(setAge(100))
    println(setAge(18))

    validateAge(17)
}

fun setAge(age: Int): Int = if (age in 18 until 100) age else 0

fun validateAge(age: Int) {
    println("Client is an eligible buyer: ${ if (age >= 18) {
        println("validating age")
        true
    } else {
        println("denying...")
        false
    }
    }")
}
