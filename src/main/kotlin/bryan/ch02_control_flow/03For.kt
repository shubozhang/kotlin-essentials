package ch02_control_flow

fun main() {

    testIterator()

    testIndex()

    testWithIndex()
}

fun testIterator(){
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

fun testIndex(){
    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println(array[i])
    }
}


fun testWithIndex(){
    val array = arrayOf("a", "b", "c")
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}
