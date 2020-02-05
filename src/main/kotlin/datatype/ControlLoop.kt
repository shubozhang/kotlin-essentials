package datatype

fun main() {
    for (a in 1..100) {
        println(a)
    }

    val numbers = 1..100
    for (a in numbers) {
        print(a)
    }

    for (a in 100 downTo 1) {
        print(a)
    }

    for (a in 100..1) {
        print(a)
    }

    for (b in 100..1 step 3) {
        print(b)
    }

    val capitals= listOf("Rome", "London", "Paris")
    for (capital in capitals) {
        println(capital)
    }
}

