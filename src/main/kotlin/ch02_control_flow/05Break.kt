package ch02_control_flow

/*
* Kotlin has three structural jump expressions:
    — return. By default returns from the nearest enclosing function or anonymous function.
    — break. Terminates the nearest enclosing loop.
    — continue. Proceeds to the next step of the nearest enclosing loop.
* */
fun main(){
    testBreakLabel()

    testContinueLabel()
}

fun testBreakLabel(){
    loop@ for (i in 1..100) {
        println("i is $i")
        for (j in 1..100) {
            println("j is $j")
            if (j == 10) {
                break@loop
            }
        }
    }
}


fun testContinueLabel(){
    loop@ for (i in 1..100) {
        println("i is $i")
        for (j in 1..100) {
            println("j is $j")
            if (j == 10) {
                continue@loop
            }
        }
    }
}
